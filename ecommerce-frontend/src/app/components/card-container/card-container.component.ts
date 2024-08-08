import { Component } from '@angular/core';
import { MatGridListModule } from '@angular/material/grid-list';
import { CardComponent } from '../card/card.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css'],
  standalone: true,
  imports: [CardComponent, MatGridListModule, CommonModule],
})
export class CardContainerComponent {
  cards = [
    {
      title: 'Card 1',
      subtitle: 'Subtitle 1',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 1',
    },
    {
      title: 'Card 2',
      subtitle: 'Subtitle 2',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 2',
    },
    {
      title: 'Card 3',
      subtitle: 'Subtitle 3',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 3',
    },
    {
      title: 'Card 4',
      subtitle: 'Subtitle 4',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 4',
    },
    {
      title: 'Card 5',
      subtitle: 'Subtitle 5',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 5',
    },
    {
      title: 'Card 6',
      subtitle: 'Subtitle 6',
      image: 'https://via.placeholder.com/150',
      content: 'Content for card 6',
    },
  ];
}
