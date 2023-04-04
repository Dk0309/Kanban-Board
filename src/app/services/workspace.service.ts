import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WorkspaceService {

  workspaceurl ="http://localhost:8083/api/workSpace";
  pillarUrl = "http://localhost:8083/api/allPillars/";
  ModifiedWorkspaceUrl = "http://localhost:8083/update/workSpace";
  savePillarUrl = "http://localhost:8083/pillar/";
  deletePillarUrl = "http://localhost:8083/api/pillars/";
  saveCardUrl = "http://localhost:8083/api/card/add/{workSpaceName}/{pillarName}";
  deleteCardUrl = "http://localhost:8083/api/card";
  constructor(private http:HttpClient) { }


  getWorkSpace():Observable<any[]>
  {
   //   return this.http.get<any>(this.workspaceurl);
     return this.http.get<any>("assets/mockdata.json");
  }

  getAllPillars(workSpace:string):Observable<any[]>
  {
    return this.http.get<any>(this.pillarUrl + workSpace);
  }

  saveWorkSpace(workspace:string, body:any):Observable<any[]>{
      console.log('body '+ JSON.stringify(body));
   return this.http.get<any>("assets/mockdata.json");
   //   return this.http.put<any>(this.ModifiedWorkspaceUrl, body, {});
  }

  savePillar(body:any):Observable<any[]>
  {
     return this.http.post<any>(this.pillarUrl + "myWorkSpace",body);
  }

  deletePillar(workspace:any,pillarName:any):Observable<any[]>
  {
     console.log(this.pillarUrl + workspace + "/" + pillarName);
     return this.http.delete<any>(this.deletePillarUrl + workspace + "/" + pillarName);
  }

  saveCard(body:any):Observable<any[]>
  {
     return this.http.post<any>(this.saveCardUrl + "myWorkSpace",body);
  }

  deleteCard(pillarName:any,workspace:any,cardId:any):Observable<any[]>
  {
     console.log(this.deleteCardUrl + "/" + pillarName + "/" + workspace + "/" +  cardId);
     return this.http.delete<any>(this.deleteCardUrl + "/" + pillarName + "/" + workspace + "/" +  cardId);
  }
}
