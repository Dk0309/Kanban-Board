import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { WorkspaceService } from 'src/app/services/workspace.service';

@Component({
  selector: 'app-user-work-space',
  templateUrl: './user-work-space.component.html',
  styleUrls: ['./user-work-space.component.css']
})
export class UserWorkSpaceComponent implements OnInit {
  Workspace:any;
  pillarName: any[];
  selectedWorkspace:any;
  cardMoveSuccess: boolean = false;
  cardMoveFailed: boolean = false;

  constructor(private workspace:WorkspaceService) { }




getWorkspaceName(workspaceName:string){
  

  this.Workspace.forEach(ws => {
      if(workspaceName === ws.workSpaceName){
        this.selectedWorkspace = ws;
      }
  });

  this.pillarName=new Array()
    this.workspace.getAllPillars(workspaceName).subscribe(data=>{
      data.forEach(element => {
        console.log(element.pillarName);
        this.pillarName.push( element.pillarName);
        console.log(this.pillarName)
      });
    })
    
}

  ngOnInit(): void {
    this.workspace.getWorkSpace().subscribe(data=>{
      this.Workspace= data;
       this.selectedWorkspace = this.Workspace[0];
      //  this.selectedWorkspace = this.Workspace;

    })

    this.cardMoveSuccess = false;
    this.cardMoveFailed = false;
  }

  onDrop(event: CdkDragDrop<string[]>, pillarName:string) {

    let movingCard:any = event.previousContainer.data[event.previousIndex];
    if((movingCard.status === 'progress' && pillarName === 'ToDo')
      || (movingCard.status === 'review' && (pillarName === 'ToDo' || pillarName === 'Progress'))
      || (movingCard.status === 'done' && (pillarName === 'ToDo' || pillarName === 'Progress' ||  pillarName === 'Review'))){
      return;
    }

    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
    }

    this.selectedWorkspace.pillars.forEach(pillar => {
      pillar.cards.forEach((card:any, index:number) => {
        if(movingCard.cardId === card.cardId){
          pillar.cards.splice(index, 1);
        }
      });   
    });

    this.selectedWorkspace.pillars.forEach(pillar => {
        if(pillar.pillarName === pillarName){
          pillar.cards.push(movingCard)
        }   
    });

    console.log('moving ' + JSON.stringify(this.selectedWorkspace));

    this.workspace.saveWorkSpace(this.selectedWorkspace.workSpaceName, this.selectedWorkspace).subscribe(data=>{
       // Show success alert
        this.cardMoveSuccess = true;
        setTimeout(() => {
          this.cardMoveSuccess = false;
        }, 3000);
      },
      err =>{
        this.cardMoveFailed = true;

        if (event.previousContainer === event.container) {
          moveItemInArray(event.previousContainer.data, event.currentIndex, event.previousIndex);
        } else {
          transferArrayItem(
            event.container.data,
            event.previousContainer.data,
            event.currentIndex,
            event.previousIndex
          );
        }

        setTimeout(() => {
          this.cardMoveFailed = false;
        }, 3000);
      })
  }

}
