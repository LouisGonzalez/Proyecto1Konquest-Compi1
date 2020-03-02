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
Punto = [.]

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

         "true"                                                             {return symbol(sym.VERDADERO);}
         "false"                                                            {return symbol(sym.FALSO);}
         "{"                                                                {return symbol(sym.LLAVE_A);}    
         "}"                                                                {return symbol(sym.LLAVE_B);}
         "["                                                                {return symbol(sym.AGRUPACION_A);}
         "]"                                                                {return symbol(sym.AGRUPACION_B);}
         ":"                                                                {return symbol(sym.DOS_PUNTOS);}
         ","                                                                {return symbol(sym.COMA);}        
         Punto                                                              {return symbol(sym.PUNTO);}    
         "\""                                                               {return symbol(sym.COMILLAS);}    
         "MAPA"                                                             {return symbol(sym.MAPA);}
         "id"                                                               {return symbol(sym.id);}
         "size"                                                             {return symbol(sym.size);}
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
         "porcentajeMuertes"                                                {return symbol(sym.porcMuertes);}    
         "PLANETAS_NEUTRALES"                                               {return symbol(sym.PLANETAS_NEUTRALES);}
         "JUGADORES"                                                        {return symbol(sym.JUGADORES);}
         "planetas"                                                         {return symbol(sym.planetas);}
         "tipo"                                                             {return symbol(sym.tipo);}
         "HUMANO"                                                           {return symbol(sym.HUMANO);}
         "DIFICIL"                                                          {return symbol(sym.DIFICIL):}
         "FACIL"                                                                     {return symbol(sym.FACIL);}
         ("(-"{Numero}+")") | {Numero}+                                              {return symbol(sym.ENTERO);}
         ({Numero2}{Numero}*{Punto}|{Punto}){Numero}*{Numero2}                       {return symbol(sym.DECIMAL);}
         ({Letra}|{Caracteres1})({Letra}|{Numero}|{Caracteres1}|{Caracteres2})*      {return symbol(sym.ID);}


}
