import java.util.Random;
import java.util.Scanner;
public class Challenge {


    public static void main(String[] args) {
        Random gerador = new Random();
        Scanner leitor = new Scanner(System.in);

            System.out.print("Digite a quantidade de produtos:");  // digitar quantidade de produtos.
            int Produtos = leitor.nextInt();

                for(int i=0; i<Produtos; i++){

                    int eixoX, eixoY;

                    System.out.print("Digite o tamanho da matriz no eixo x do produto " + (i+1) + ":");    
                    eixoX= leitor.nextInt();

                    System.out.print("Digite o tamanho da matriz no eixo Y  do produto " + (i+1) + ":");    
                    eixoY = leitor.nextInt();

                    /*                
                    tamanhoVetorX*tamanhoVetorY=x;
                    aux+=x;                                                     
                    for(i=0;i<aux;i++){                              Desenvolver, parte que delimita o tamanho da                             
                        if ((aux/i))                                 matriz.

                    }
                    */


                    int matriz[][]= new int [eixoX][eixoY];
              

                    System.out.print("Digite o codigo do produto:");       // for que acrescenta os valores a matriz.
                    int CodigoProduto = leitor.nextInt();

                    for(int j=0; j<eixoX; j++){     
                      
                        System.out.println("valor :" + eixoX +" valor: " + eixoY);

                        for(int k=0;k<eixoY;k++){
                            int x= gerador.nextInt(4) + 1;
                            int y= gerador.nextInt(4) + 1;  
                            matriz[x][y]=CodigoProduto;
                        }                      
                    }


                    if(i==(Produtos-1)){
                        for(int l=0; l< eixoX; l++){    
                            System.out.print("{ ");                                    //For para mostrar a matriz. 
                            for(int m=0;m<eixoY;m++){
                                System.out.print(matriz[l][m]+ " ");                              
                            }         
                            System.out.print("}");
                            System.out.println(" ");
                        }
                    }
                }
       }             
}
