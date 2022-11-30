import { Component } from '@angular/core';
import { SorterService } from './services/sorter.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  numbers: string = "";
  error: boolean = false;

  constructor(private service: SorterService) { }

  callSortApi(numbers: string, order: string) {
  if(this.error){
    this.error = false;
  }
  let numArray: number[] = this.validateInput(numbers);
  this.service.postSort(numArray, order.toUpperCase()).subscribe((data) =>{
    this.numbers = data.numbers.toString();
  })


}

validateInput(numbers : String) : number[]{
    let numArray : number[] = numbers.split(",").map(str => {
      if(isNaN(Number(str))){
        this.error = true;
        throw new Error("invalid input");
      }
      return Number(str);
    })
    return numArray;
  };



  title = 'numList';
}
