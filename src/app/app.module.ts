import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { ErrorComponent } from './error/error.component';
import { InitComponent } from './init/init.component';
import { InformationCompanyComponent } from './information-company/information-company.component';
import { AgregarUsuarioComponent } from './user/agregar-usuario/agregar-usuario.component';
import { EditarUsuarioComponent } from './user/editar-usuario/editar-usuario.component';
import { DetailProductComponent } from './detail-product/detail-product.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UserComponent,
    LoginComponent,
    ProductComponent,
    ErrorComponent,
    InitComponent,
    InformationCompanyComponent,
    AgregarUsuarioComponent,
    EditarUsuarioComponent,
    DetailProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
