import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActividadesPageComponent } from './components/pages/actividades-page/actividades-page.component';
import { CentroPageComponent } from './components/pages/centro-page/centro-page.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { ObjetivosPageComponent } from './components/pages/objetivos-page/objetivos-page.component';
import { PerfilPageComponent } from './components/pages/perfil-page/perfil-page.component';
import { SociosPageComponent } from './components/pages/socios-page/socios-page.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginPageComponent
  },
  {
    path: 'objetivos',
    component: ObjetivosPageComponent
  },
  {
    path: 'actividades',
    component: ActividadesPageComponent
  },
  {
    path: 'perfil',
    component: PerfilPageComponent
  },
  {
    path: 'centro',
    component: CentroPageComponent
  },
  {
    path: 'socios',
    component: SociosPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
