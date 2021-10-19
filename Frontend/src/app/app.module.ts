import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { MyReservationsComponent } from './my-reservations/my-reservations.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ObjectComponent } from './object/object.component';
import { TenisComponent } from './object/tenis/tenis.component';
import { FootballComponent } from './object/football/football.component';
import { BasketballComponent } from './object/basketball/basketball.component';
import { RouterModule } from '@angular/router';
import { UsersListComponent } from './users-list/users-list.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserService } from 'src/_services/user.service';
import { ReservationService } from 'src/_services/reservation.service';
import { SportObjectService } from 'src/_services/sport_object.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from 'src/_services/authentication.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserComponent,
    AdminComponent,
    MyReservationsComponent,
    DashboardComponent,
    ObjectComponent,
    TenisComponent,
    FootballComponent,
    BasketballComponent,
    UsersListComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'login', component: LoginComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'dashboard', component: DashboardComponent},
      {path: 'admin', component: AdminComponent},
      {path: 'user', component: UserComponent},
      {path: 'tenis', component: TenisComponent},
      {path: 'basketball', component: BasketballComponent},
      {path: 'football', component: FootballComponent},
      {path: 'myreservations', component: MyReservationsComponent},
      {path: 'object', component: ObjectComponent},
      {path: 'userslist', component: UsersListComponent},
      {path: '', component: HomeComponent}
    ]),
    NgbModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [UserService, ReservationService, SportObjectService, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
