import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActividadFormComponent } from './components/forms/actividad-form/actividad-form.component';
import { ObjetivoFormComponent } from './components/forms/objetivo-form/objetivo-form.component';
import { ActividadInfoPageComponent } from './components/pages/actividad-info-page/actividad-info-page.component';
import { ActividadesPageComponent } from './components/pages/actividades-page/actividades-page.component';
import { CentroPageComponent } from './components/pages/centro-page/centro-page.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { ObjetivoInfoPageComponent } from './components/pages/objetivo-info-page/objetivo-info-page.component';
import { ObjetivosPageComponent } from './components/pages/objetivos-page/objetivos-page.component';
import { PerfilPageComponent } from './components/pages/perfil-page/perfil-page.component';
import { SocioInfoPageComponent } from './components/pages/socio-info-page/socio-info-page.component';
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
    path: 'objetivos/editar/:id',
    component: ObjetivoFormComponent
  },
  {
    path: 'objetivos/crear',
    component: ObjetivoFormComponent
  },
  {
    path: 'actividades',
    component: ActividadesPageComponent
  },
  {
    path: 'actividades/ver/:id',
    component: ActividadInfoPageComponent
  },
  {
    path: 'actividades/editar/:id',
    component: ActividadFormComponent
  },
  {
    path: 'actividades/crear',
    component: ActividadFormComponent
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
  },
  {
    path: 'socios/ver/:id',
    component: SocioInfoPageComponent
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
