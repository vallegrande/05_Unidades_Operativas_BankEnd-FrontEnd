import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UnitModel } from 'src/app/model/unit-model';
import { UnitService } from 'src/app/service/unit.service';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.css']
})
export class UnitComponent implements OnInit {

  listUnits: UnitModel [] = [];
  formUnit: FormGroup = new FormGroup({});
  isUpdate: boolean = false;




  constructor(private unitService: UnitService) { }

  ngOnInit(): void {
    this.list();
    this.formUnit =  new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      director : new FormControl(''),
      telephone :new FormControl(''),
      address : new FormControl(''),
      department : new FormControl(''),
      active : new FormControl('A')
    });
  }

  list(){
    this.unitService.getUnits().subscribe(resp=>{
      if(resp){
        this.listUnits = resp;
      }
    })
  }

  save(){
    this.formUnit.controls['active'].setValue('A');
    this.unitService.saveUnits(this.formUnit.value).subscribe(resp=>{
      if(resp){
        this.list();
        this.formUnit.reset();
      }
    });
  }

  update(){
    this.unitService.updateUnits(this.formUnit.value).subscribe(resp=>{
      if(resp){
        this.list();
        this.formUnit.reset();
      }
    });
  }

  delete(id: any){
    this.unitService.deleteUnits(id).subscribe(resp=>{
      if(resp){
        this.list();
        this.formUnit.reset();
      }
    });
  }

  newCard(){
    this.isUpdate = false;
    this.formUnit.reset();
  }

  selectItem(item: any){
    this.isUpdate = true;
    this.formUnit.controls['id'].setValue(item.id);
    this.formUnit.controls['name'].setValue(item.name);
    this.formUnit.controls['director'].setValue(item.director);
    this.formUnit.controls['telephone'].setValue(item.telephone);
    this.formUnit.controls['address'].setValue(item.address);
    this.formUnit.controls['department'].setValue(item.department);
  }


}










