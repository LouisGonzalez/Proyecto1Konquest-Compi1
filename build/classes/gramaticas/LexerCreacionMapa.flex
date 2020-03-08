package gramaticas;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico
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
         ","                                                              {return symbol(sym.COMA);}  
         "true"                                                             {return symbol(sym.VERDADERO, new String(yytext()));}
         "false"                                                            {return symbol(sym.FALSO, new String(yytext()));}
         "{"                                                                {return symbol(sym.LLAVE_A);}    
         "}"                                                                {return symbol(sym.LLAVE_B);}
         "["                                                                {return symbol(sym.AGRUPACION_A);}
         "]"                                                                {return symbol(sym.AGRUPACION_B);}
         ":"                                                                {return symbol(sym.DOS_PUNTOS);}
         "."                                                                {return symbol(sym.PUNTO);}    
         "\""                                                               {return symbol(sym.COMILLAS);}    
         "MAPA"                                                             {return symbol(sym.MAPA);}
         "id"                                                               {return symbol(sym.id);}
         "size"                                                             {return symbol(sym.size);}
         "filas"                                                            {return symbol(sym.filas);}
         "columnas"                                                         {return symbol(sym.columnas);}
         "alAzar"                                                           {return symbol(sym.alAzar);}
         "planetasNeutrales"                                                {return symbol(sym.pNeutrales);}    
         "mapaCiego"                                                        {return symbol(sym.mapaCiego);}            
         "acumular"                                                         {return symbol(sym.acumular);}  
            "NEUTRALES"                                                     {return symbol(sym.NEUTRALES);}    
            "mostrarNaves"                                                  {return symbol(sym.mostrarNaves);}
            "mostrarEstadisticas"                                           {return symbol(sym.mostrarEstadisticas);}
            "produccion"                                                    {return symbol(sym.produccion);}
            "finalizacion"                                                  {return symbol(sym.finalizacion);}
         "PLANETAS"                                                         {return symbol(sym.PLANETAS);}
         "nombre"                                                           {return symbol(sym.nombre);}
         "naves"                                                            {return symbol(sym.naves);}
         "posicionX"                                                        {return symbol(sym.posX);}    
         "posicionY"                                                        {return symbol(sym.posY);}
         "porcentajeMuertes"                                                {return symbol(sym.porcMuertes);}    
         "PLANETAS_NEUTRALES"                                               {return symbol(sym.PLANETAS_NEUTRALES);}
         "JUGADORES"                                                        {return symbol(sym.JUGADORES);}
         "planetas"                                                         {return symbol(sym.planetas);}
         "tipo"                                                             {return symbol(sym.tipo);}
         "color"                                                            {return symbol(sym.color);}
         "HUMANO"                                                           {return symbol(sym.HUMANO, new String(yytext()));}
         "DIFICIL"                                                                   {return symbol(sym.DIFICIL, new String(yytext()));}
         "FACIL"                                                                     {return symbol(sym.FACIL, new String(yytext()));}
         {Numero}*{Coma}{Numero}*{Coma}{Numero}*{Coma}{Numero}*                      {return symbol(sym.COLOR, new String(yytext()));}
         ("(-"{Numero}+")") | {Numero}+                                              {return symbol(sym.ENTERO, new Integer(yytext()));}
         ({Numero2}{Numero}*{Punto}|{Punto}|{Numero}{Punto}){Numero}*{Numero}                       {return symbol(sym.DECIMAL, new Double(yytext()));}
         ({Letra}|{Caracteres1})({Letra}|{Numero}|{Caracteres1}|{Caracteres2})*      {return symbol(sym.ID, new String(yytext()));}
         {Espacio}*                                                                  {/*Ignore*/}
          .                                                                          {}
            

}
