#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int si;
void buscar (char t[si], char p[50]);
void cadenaPre ();
void cadenaAle (int n);

int
main ()
{
  int opc;
  printf ("|----------------------------|\n");
  printf ("| Cadena al azar ----------1 |\n");
  printf ("| Ingresar Cadena ---------2 |\n");
  printf ("|----------------------------|\n");

  scanf ("%d", &opc);

  system ("clc");

  switch (opc)
    {
    case 1:
      {
	int rango;
	printf ("Rango de la cadena: ");
	scanf ("%d", &rango);
	cadenaAle (rango);
	break;
      }
    case 2:
      {
	cadenaPre ();
      }
    default:
      {
	break;
      }
    }

  return 0;
}

void
buscar (char t[], char p[])
{

  int dim;
  int concidencia = 0;

  dim = strlen (p);

  for (int i = 0; i < strlen (t); i++)
    {				//Fuerza Bruta

      if (t[i] == p[0])
	{

	  for (int j = 0; j < dim; j++)
	    {
	      if (t[i + j] != p[j])
		{
		  break;
		  i += dim;
		}
	      else
		{
		  if (j == dim - 1)
		    {
		      concidencia += 1;
		      printf ("Patron encontrado en %d \n", i + 1);
		    }
		}
	    }
	}
    }
  printf ("\nNumero de concidencias %d", concidencia);
}

void
cadenaPre ()
{				//Cadena dada

  char cad[500];
  char pat[50];

  printf ("Cadena\n");		//Pide Cadena
  scanf ("%s", &cad);

  printf ("\nPatron\n");	//Pide Patron
  scanf ("%s", &pat);

  buscar (cad, pat);
}

void
cadenaAle (int n)
{				//Cadena aleatoria

  char cad[n];
  char pat[50];
  int r;
  srand (time (NULL));

  printf ("\nPatron\n");	//Pide Patron
  scanf ("%s", &pat);

  for (int i = 0; i < n; i++)
    {
      cad[i] = (rand () % 25) + 97;
    }

  buscar (cad, pat);
}
