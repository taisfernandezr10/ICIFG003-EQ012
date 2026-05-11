import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonasPage } from './personas-page';

describe('PersonasPage', () => {
  let component: PersonasPage;
  let fixture: ComponentFixture<PersonasPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PersonasPage],
    }).compileComponents();

    fixture = TestBed.createComponent(PersonasPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
