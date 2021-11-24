package br.edu.ifsp.sc300323x.willer.dados

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
//Foi colocado valores padrões
data class Configuracao( val numeroDados:Int = 1, val numeroFaces: Int = 6): Parcelable
