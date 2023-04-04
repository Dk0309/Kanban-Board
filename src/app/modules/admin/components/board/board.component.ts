import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators,NgForm } from '@angular/forms';
import { WorkspaceService } from 'src/app/services/workspace.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {
  // boardForm = new FormGroup({
  //   pillarName: new FormControl('',Validators.required)
  // }); 
  constructor(private workspace:WorkspaceService) { }

  ngOnInit(): void {
  }
  sendBoardData(boardForm:NgForm)
  {
      // this.workspace.savePillar(data).subscribe(data1 =>{
        console.log(boardForm.value);
      // })
  } 
}
