import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { NavigationComponent } from './components/navigation/navigation.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { FooterComponent } from './components/footer/footer.component';
import { CommonModule } from '@angular/common';
import { CardContainerComponent } from './components/card-container/card-container.component';
import { CardComponent } from './components/card/card.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterModule,
    NavigationComponent,
    CarouselComponent,
    FooterComponent,
    CommonModule,
    CardContainerComponent,
    CardComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  carouselImages1 = [
    { id: 1, imageUrl: '/macbook.png' },
    { id: 2, imageUrl: '/picture2.jpg' },
    { id: 3, imageUrl: '/picture3.jpg' },
    { id: 4, imageUrl: '/picture4.jpg' },
  ];

  carouselImages2 = [
    { id: 1, imageUrl: '/image1.jpg' },
    { id: 2, imageUrl: '/image2.jpg' },
    { id: 3, imageUrl: '/image3.jpg' },
    { id: 4, imageUrl: '/image4.jpg' },
  ];
}
