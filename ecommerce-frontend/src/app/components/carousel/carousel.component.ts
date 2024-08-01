import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { NzCarouselModule } from 'ng-zorro-antd/carousel';

@Component({
  selector: 'app-carousel',
  standalone: true,
  imports: [NzCarouselModule, CommonModule],
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css'],
})
export class CarouselComponent {
  @Input() images: { id: number; imageUrl: string }[] = [];
}
