import { Component, OnInit } from '@angular/core';

import { Hero } from 'src/app/heroes/hero';
//import { HEROES } from 'src/app/mock-heroes';

import { HeroService } from 'src/app/hero.service'
//import {MessageService} from ;

import { MessageService } from 'src/app/message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
//export da interface objto
export class HeroesComponent implements OnInit{
 // hero: Hero = {
   // id: 1,
   // name: 'Windstorm',
  // heroes = HEROES;
 // };
selectedHero?: Hero;

heroes: Hero[] = [];

constructor(private heroService: HeroService, private messageService: MessageService) {}

ngOnInit(): void {
  this.getHeroes();
}

onSelect(hero: Hero): void {
  this.selectedHero = hero;
  this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
}


getHeroes(): void {
  this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes);
}

delete(hero: Hero): void {
  this.heroes = this.heroes.filter(h => h !== hero);
  this.heroService.deleteHero(hero.id).subscribe();
}

}
