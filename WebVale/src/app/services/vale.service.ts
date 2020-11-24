import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ValeService {

  API_URI = 'http://localhost:3000/api';

  constructor(private http: HttpClient) {}

  /*getContenedores() {
    return this.http.get(`${this.API_URI}/`)
  }*/

  getLogIn(username: string, password: string) {
    return this.http.get(`${this.API_URI}/vale/login/${username}/${password}`)
  }


}
