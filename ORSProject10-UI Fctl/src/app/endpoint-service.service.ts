import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = "http://localhost:8084";
  public MESSAGE = this.SERVER_URL + "/Message";
  public USER = this.SERVER_URL + "/User";
  public SHOPPING = this.SERVER_URL + "/Shopping";
  public PAYMENT = this.SERVER_URL + "/Payment";
  public CLIENT = this.SERVER_URL + "/Client";
  public PRIORITY = this.SERVER_URL + "/Priority";
  public ROLE = this.SERVER_URL + "/Role";
  public ORDER = this.SERVER_URL + "/Order";
  public PRODUCTDETAILS = this.SERVER_URL + "/ProductDetails";
  public PRODUCT = this.SERVER_URL + "/Product";
  public PATIENT = this.SERVER_URL + "/Patient";
  public COLLEGE = this.SERVER_URL + "/College";
  public MARKSHEET = this.SERVER_URL + "/Marksheet";
  public STUDENT = this.SERVER_URL + "/Student";
  public SUBJECT = this.SERVER_URL + "/Subject";
  public FACULTY = this.SERVER_URL + "/Faculty";
  public COURSE = this.SERVER_URL + "/Course";
  public TIMETABLE = this.SERVER_URL + "/TimeTable";
  public JASPERREPORT = this.SERVER_URL + "/Jasper";

}
