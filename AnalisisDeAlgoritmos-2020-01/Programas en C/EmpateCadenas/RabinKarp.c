#include <stdio.h>
#include <string.h>
#define d 117

void buscar (char patron[], char texto[], int primo);

int
main ()
{
  char texto[500];
  char patron[50];

  printf ("Ingresar la cadena: ");
  scanf ("%s", texto);

  printf ("Ingresar el patron: ");
  scanf ("%s", patron);

  int primo = 1223;
  buscar (patron, texto, primo);


  return 0;
}

void
buscar (char patron[], char texto[], int primo)
{
  int M = strlen (patron);
  int N = strlen (texto);

  int i, j;

  int hashpatron = 0;			// hash de patron
  int hashtexto = 0;			// hash de texto 
  int h = 1;

  for (i = 0; i < M - 1; i++)  //El valor de h sera pow(d, M-1)%primo
    h = (h * d) % primo;

  for (i = 0; i < M; i++)
    {				//Calcular el hash de patron y la primera ventana
      hashpatron = (d * hashpatron + patron[i]) % primo;
      hashtexto = (d * hashtexto + texto[i]) % primo;

    }

  for (i = 0; i <= N - M; i++)
    {				// recorremos el texto uno a uno

      if (hashpatron == hashtexto)
	{			//Si los hash del la ventana y el patron son 
	  //iguales, verificamos

	  for (j = 0; j < M; j++)
	    {
	      if (texto[i + j] != patron[j])
		break;
	    }

	  if (j == M)

	    printf ("Concidencia en %d \n", i);
	}

      if (i < N - M)
	{			//Calculamos el hash de la ventana
	  hashtexto = (d * (hashtexto - texto[i] * h) + texto[i + M]) % primo;

	  if (hashtexto < 0)
	    hashtexto = (hashtexto + primo);
	}
    }
}
