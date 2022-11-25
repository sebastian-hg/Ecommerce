import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { InformationCompanyComponent } from './information-company/information-company.component';
import { InitComponent } from './init/init.component';
import { ProductComponent } from './product/product.component';
import { AgregarUsuarioComponent } from './user/agregar-usuario/agregar-usuario.component';
import { EditarUsuarioComponent } from './user/editar-usuario/editar-usuario.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'', component:InitComponent},
  {path:'productos', component:ProductComponent},
  {path:'nosotros', component:InformationCompanyComponent},
  {path:'usuarios', component:UserComponent, children:[
      {path:'agregar', component:AgregarUsuarioComponent},
      {path:'editar', component:EditarUsuarioComponent}
    ]
  },
  {path:'**', component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
