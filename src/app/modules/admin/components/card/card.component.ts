import { Component, OnInit } from '@angular/core';
import { WorkspaceService } from 'src/app/services/workspace.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  cardForm = new FormGroup({
    pillarName: new FormControl('',Validators.required)
  });
  constructor(private workspace:WorkspaceService) { }

  ngOnInit(): void {
  }
  sendCardData(data:any)
  {
    this.workspace.saveCard(data).subscribe(data1 =>{
            console.log(data1);
            
    })
  }
}
