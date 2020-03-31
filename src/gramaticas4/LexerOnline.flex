package gramaticas4;
import java_cup.runtime.Symbol;
import interfaz.VentanaPrincipal;

%%
%public 
%class AnalizadorLexico4
%cup
%cupdebug
%line
%column

/*Identificadores*/
Letra = [a-zA-Z]
Numero = [0123456789]
Numero2 = [123456789]
Caracteres1 = [$_]
Caracteres2 = [-]
Coma = [,]
Punto = [.]
Salto = \r|\n|\r\n
Espacio = {Salto} | [ \t\f]

%{
    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }
%}
%%
<YYINITIAL> {
         ","                                                                {return symbol(sym.COMA);}  
         "true"                                                             {return symbol(sym.VERDADERO, new String(yytext()));}
         "false"                                                            {return symbol(sym.FALSO, new String(yytext()));}
         "{"                                                                {return symbol(sym.LLAVE_A);}    
         "}"                                                                {return symbol(sym.LLAVE_B);}
         "["                                                                {return symbol(sym.AGRUPACION_A);}
         "]"                                                                {return symbol(sym.AGRUPACION_B);}
         ":"                                                                {return symbol(sym.DOS_PUNTOS);}
         "."                                                                {return symbol(sym.PUNTO);}    
         "\""                                                               {return symbol(sym.COMILLAS);}    
         "ACCIONES"                                                         {return symbol(sym.ACCIONES);}
         "Flota"                                                            {return symbol(sym.Flota);}
         "planetaOrigen"                                                    {return symbol(sym.planetaOrigen);}
         "planetaDestino"                                                   {return symbol(sym.planetaDestino);}
         "noNaves"                                                          {return symbol(sym.noNaves);} 
         "noJugadorEnvio"                                                   {return symbol(sym.noJugadorEnvio);}
         "noJugadorAtaque"                                                  {return symbol(sym.noJugadorAtaque);}
         "turnoLlegada"                                                     {return symbol(sym.turnoLlegada);}
         "verificador"                                                      {return symbol(sym.verificador);}
         "IMPACTOS"                                                         {return symbol(sym.IMPACTOS);}
         "porcentajeMuertes"                                                {return symbol(sym.porcMuertes);}
         "navesRestantes"                                                   {return symbol(sym.navesRestantes);}
         "estado"                                                           {return symbol(sym.estado);}
         "mensaje"                                                          {return symbol(sym.mensaje);}
         "estadoJugador"                                                    {return symbol(sym.estadoJugador);}
         "noFlota"                                                          {return symbol(sym.noFlota);}
         "jugadorAtacante"                                                  {return symbol(sym.jugadorAtacante);}
         "planetaAtacante"                                                  {return symbol(sym.planetaAtacante);}        
         "RESUMEN"                                                          {return symbol(sym.RESUMEN);}
         "VIVO"                                                             {return symbol(sym.VIVO);}
         "CONQUISTADO"                                                      {return symbol(sym.CONQUISTADO);}
         "SECUENCIAS"                                                       {return symbol(sym.SECUENCIAS);}
         "turnoJugador"                                                     {return symbol(sym.turnoJugador);}
         "turno"                                                            {return symbol(sym.turno);}
         "GENERAL"                                                          {return symbol(sym.GENERAL);}
         "HUMANO"                                                           {return symbol(sym.HUMANO, new String(yytext()));}
         "DIFICIL"                                                                   {return symbol(sym.DIFICIL, new String(yytext()));}
         "FACIL"                                                                     {return symbol(sym.FACIL, new String(yytext()));}
         {Numero}*{Coma}{Numero}*{Coma}{Numero}*{Coma}{Numero}*                      {return symbol(sym.COLOR, new String(yytext()));}
         ("(-"{Numero}+")") | {Numero}+                                              {return symbol(sym.ENTERO, new Integer(yytext()));}
         ({Numero2}{Numero}*{Punto}|{Punto}|{Numero}{Punto}){Numero}*{Numero}                       {return symbol(sym.DECIMAL, new Double(yytext()));}
         ({Letra}|{Caracteres1})({Letra}|{Numero}|{Caracteres1}|{Caracteres2})*      {return symbol(sym.ID, new String(yytext()));}
         {Espacio}*                                                                  {/*Ignore*/}
         .                                                                           { String error = "Error lexico token: \""+yytext()+"\". Linea: "+(yyline+1)+" Columna: "+(yycolumn+1)+".\n"; VentanaPrincipal.notificarError(error); }





}

