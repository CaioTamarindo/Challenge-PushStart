import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Desafio{
    public static void main(String[] args) {

        Random gerador = new Random();
        Scanner leitor = new Scanner(System.in);

        System.out.println("=======================================================================");
        System.out.println("                            Olá Seja bem vindo:                        ");
        System.out.println(" Abaixo iniciara o programa e voce devera colocar os dados do mesmo :) ");
        System.out.println("=======================================================================");
        //Entrada de valores sobre a matriz principal
        System.out.print("Digite o valor da altura da matriz principal:"); 
        int alturaMatrizGrande = leitor.nextInt();

        System.out.print("Digite o valor da largura da matriz principal:");
        int larguraMatrizGrande = leitor.nextInt();

        //matriz principal
        int matrizGrande[][]= new int [alturaMatrizGrande][larguraMatrizGrande];

        //matriz com 1 nos locais que possuem algo
        int matrizLocaisUtilizados[][]= new int [alturaMatrizGrande][larguraMatrizGrande];

        //Entrada de quantos produtos serão colocados na matriz grande.
        System.out.print("Digite a quantidade de produtos:");  // digitar quantidade de produtos.
        int Produtos = leitor.nextInt();


        //matriz utilizada como banco de dados dos produtos
        int matrizPeças[][]= new int [Produtos][4];    
  
        var listaValores = new ArrayList();

        int contador=0;
        

        //For utilizado para colocar os valores na matriz banco de dados
        for(int i=0;i<Produtos;i++){
            System.out.print("Digite o valor do Codigo do produto:"); 
            int Codigo = leitor.nextInt();

            System.out.print("Digite o valor da altura do produto:");
            int altura = leitor.nextInt();
       
            System.out.print("Digite o valor da largura do produto:"); 
            int largura = leitor.nextInt();



            matrizPeças[i][0]=contador;

            //Lista utilizada para fazer o controle de quantos valores tem e utiliza-los se necessario
            listaValores.add(contador);
            contador=contador+1;                                             
            matrizPeças[i][1]=Codigo;
            matrizPeças[i][2]=altura;
            matrizPeças[i][3]=largura;
        }


       




        
        
        for(int i=0; i<Produtos;i++){                  


            //numero aleatorio para organizar 
            int aleatorio = gerador.nextInt(listaValores.size());

            System.out.print("o numero aleatorio é: " + aleatorio);
            int primeirok;
            int primeirol;
            var primeiroLargura = new ArrayList();
                
            for(int j=0;j<Produtos;j++){                       
                //se o valor aleatorio for igual ao valor designado para aquele produto:
                if (matrizPeças[j][0]==aleatorio){
                    
                    //primeiro caso:
                    if(i==0){
                        //for para verificar toda a matriz
                        for(int k=0;k<matrizPeças[j][2];k++){
                            for(int l=0;l<matrizPeças[j][3];l++){            
                                matrizGrande[k][l]=matrizPeças[j][1];
                                //matriz utilizada como base sendo onde ela tem valor 1 tendo espaço ocupado
                                matrizLocaisUtilizados[k][l]=1;
                                if(k==matrizPeças[j][2]-1 && l==matrizPeças[j][3]-1){
                                    listaValores.remove(aleatorio);
                                    break;
                                }
                            }                      
                        }
                    }
                    
                    else{
                        boolean Altura=false;
                        boolean Largura=false;
                        while(!(Altura==false && Largura==false)){

                            //for verificador da largura  disponivel 
                            int somadorLargura=0;
                                
                            while(somadorLargura!= matrizPeças[j][3]){   
                                for(int k=0;k<alturaMatrizGrande;k++){
                                    for(int l=0;l<larguraMatrizGrande;l++){
                                        if(matrizLocaisUtilizados[k][l]!=1){
                                            somadorLargura=somadorLargura+1;
                                        }
                                        if(somadorLargura==1){
                                            primeiroLargura.add(k);
                                            primeiroLargura.add(l);
                                        }
                                                    
                                        if(somadorLargura==matrizPeças[j][3]){                                            
                                            Largura=true;
                                            break;
                                        }
                                            
                                        if(matrizLocaisUtilizados[k][l]==1){
                                            somadorLargura=0;
                                            primeiroLargura.clear();
                                        }
                                    }
                                    if(somadorLargura==matrizPeças[j][3]){
                                        System.out.println("Largura "+ Largura);
                                        break;
                                    }
                                }        
                            } 
                              
                            //primeiro valor onde tem espaço disponivel
                            primeirok=(int)primeiroLargura.get(0);
                            primeirol=(int)primeiroLargura.get(1);
                                                         
                            //for verificador da altura disponivel 
                            int somadorAltura=0;
                               
                            
                            while(somadorAltura!=matrizPeças[j][2]){
                                primeirok=(int)primeiroLargura.get(0);
                                primeirol=(int)primeiroLargura.get(1);

                                //verificar altura disponivel tendo em base a largura que deu true
                                for(int k=primeirok ;k <(matrizPeças[j][2] + primeirok);k++){
                                    if(matrizLocaisUtilizados[k][primeirol]!=1){
                                        somadorAltura=somadorAltura+1;
                                    }                                 
                                    if(somadorAltura==matrizPeças[j][2]){                                            
                                        Altura=true;
                                        System.out.println("Altura "+ Altura);
                                        listaValores.remove(aleatorio);
                                        break;
                                    }
                                }
                            }         
                        }

                        primeirok=(int)primeiroLargura.get(0);
                        primeirol=(int)primeiroLargura.get(1);


                        // se sair do while que dizer que Altura=true e Largura=true 
                        //entao comeca a preencher a matriz junto cm a matriz auxiliar 
                        for(int k=(int) primeirok;k<matrizPeças[j][2];k++){
                            for(int l= (int) primeirol;l<matrizPeças[j][2];l++){
                                matrizGrande[k][l]=matrizPeças[j][1];
                                matrizLocaisUtilizados[k][l]=1;
                            }               
                        }  
                    }
                   
                }
                break;          
            }

  
            

            // para apresentar a matriz
            System.out.println(" ");    

            for(int j=0;j<alturaMatrizGrande;j++){
                System.out.print("{ "); 
                for(int k=0;k<larguraMatrizGrande;k++){
                    System.out.print(matrizGrande[j][k] + " ");   
                }
                System.out.print("}");
                System.out.println(" ");
            }                           
        }             
    }
}


    


                    
           
            


                    

                         
                  
                
                    
 


