import { CommonModule } from '@angular/common';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatCard } from '@angular/material/card';

@Component({
  selector: 'app-logo-carousel',
  standalone: true,
  imports: [CommonModule, MatIconModule, MatCard],
  templateUrl: './logo-carousel.component.html',
  styleUrl: './logo-carousel.component.css',
})
export class LogoCarouselComponent implements OnInit, OnDestroy {
  images = [
    'https://via.placeholder.com/150x100?text=Logo+1',
    'https://via.placeholder.com/150x100?text=Logo+2',
    'https://via.placeholder.com/150x100?text=Logo+3',
    'https://via.placeholder.com/150x100?text=Logo+4',
    'https://via.placeholder.com/150x100?text=Logo+5',
    'https://via.placeholder.com/150x100?text=Logo+6',
    // Add more image URLs
  ];

  visibleImages: string[];
  private intervalId: any;

  constructor() {
    this.visibleImages = this.images.slice(0, 6); // Show 6 images at a time
  }

  ngOnInit(): void {
    this.intervalId = setInterval(() => this.next(), 3000); // Slide every 3 seconds
  }

  ngOnDestroy(): void {
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }

  next() {
    this.images.push(this.images.shift()!); // Move the first image to the end
    this.visibleImages = this.images.slice(0, 6);
  }

  prev() {
    this.images.unshift(this.images.pop()!); // Move the last image to the front
    this.visibleImages = this.images.slice(0, 6);
  }
}
