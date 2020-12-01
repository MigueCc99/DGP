import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavMenuComponent } from './components/nav-menu/nav-menu.component';
import { CentroPageComponent } from './components/pages/centro-page/centro-page.component';
import { ActividadesPageComponent } from './components/pages/actividades-page/actividades-page.component';
import { ObjetivosPageComponent } from './components/pages/objetivos-page/objetivos-page.component';
import { PerfilPageComponent } from './components/pages/perfil-page/perfil-page.component';
import { SociosPageComponent } from './components/pages/socios-page/socios-page.component';
import { SocioFormComponent } from './components/forms/socio-form/socio-form.component';
import { FacilitadorFormComponent } from './components/forms/facilitador-form/facilitador-form.component';
import { NuevaContraFormComponent } from './components/forms/nueva-contra-form/nueva-contra-form.component';
import { ObjetivoInfoPageComponent } from './components/pages/objetivo-info-page/objetivo-info-page.component';
import { ActividadInfoPageComponent } from './components/pages/actividad-info-page/actividad-info-page.component';
import { SocioActividadPageComponent } from './components/pages/socio-actividad-page/socio-actividad-page.component';
import { SocioInfoPageComponent } from './components/pages/socio-info-page/socio-info-page.component';
import { ObjetivoFormComponent } from './components/forms/objetivo-form/objetivo-form.component';
import { ActividadFormComponent } from './components/forms/actividad-form/actividad-form.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { FormsModule } from '@angular/forms';
import { ConstantsComponent } from './components/constants/constants.component';
import { FacilitadoresPageComponent } from './components/pages/facilitadores-page/facilitadores-page.component';
import { SociosRecuperaContraPageComponent } from './components/pages/socios-recupera-contra-page/socios-recupera-contra-page.component';

@NgModule({
  declarations: [
    AppComponent,
    NavMenuComponent,
    CentroPageComponent,
    ActividadesPageComponent,
    ObjetivosPageComponent,
    PerfilPageComponent,
    SociosPageComponent,
    SocioFormComponent,
    FacilitadorFormComponent,
    NuevaContraFormComponent,
    ObjetivoInfoPageComponent,
    ActividadInfoPageComponent,
    SocioActividadPageComponent,
    SocioInfoPageComponent,
    ObjetivoFormComponent,
    ActividadFormComponent,
    LoginPageComponent,
    ConstantsComponent,
    FacilitadoresPageComponent,
    SociosRecuperaContraPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
