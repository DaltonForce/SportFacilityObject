import { Component, OnInit } from '@angular/core';
import { SportObjectService } from 'src/_services/sport_object.service';
import { Sport_Object } from 'src/_models/sport_object';
import { Reservation } from 'src/_models/reservation';

@Component({
  selector: 'app-object',
  templateUrl: './object.component.html',
  styleUrls: ['./object.component.css']
})
export class ObjectComponent implements OnInit {

  constructor() { } 

  ngOnInit() {

  }

}
