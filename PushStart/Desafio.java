import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Desafio{
    public static void main(String[] args) {

        Random gerador = new Random();
        Scanner leitor = new Scanner(System.in);


        //Entrada de valores sobre a matriz principal
        System.out.print("Digite o valor da altura da matriz principal:"); 
        int alturaMatrizGrande = leitor.nextInt();

        System.out.print("Digite o valor da largura da matriz principal:");
        int larguraMatrizGrande = leitor.nextInt();

        //matriz principal
        int matrizGrande[][]= new int [alturaMatrizGrande][larguraMatrizGrande];

        //matriz com 1 nos locais que possuem algo
        int matrizLocaisUtilizados[][]= new int [alturaMatrizGrande][larguraMatrizGrande];

        //matriz com 1 nos lugares disponiveis.
        int matrizAuxiliar[][]= new int [alturaMatrizGrande][larguraMatrizGrande];


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

       




        while(listaValores.size() !=0){
            //Numero aleatorio que escolhera um valor correspondente na lista para organizar
            for(int i=0; i<Produtos;i++){                  
                    //remove o numero aleatorio para não ter repetições
                int aleatorio = gerador.nextInt(contador);
                listaValores.remove(aleatorio);
                for(int j=0;j<Produtos;j++){                       
                    //se o valor aleatorio for igual ao valor designado para aquele produto:
                    
                    if (matrizPeças[j][0]==aleatorio){
                        boolean Altura=false;
                        boolean Largura=false;
                        //primeiro caso:
                        if(i==0){
                            //for para verificar toda a matriz
                            for(int k=0;k<matrizPeças[j][2];k++){
                                for(int l=0;l<matrizPeças[j][3];l++){            
                                    matrizGrande[k][l]=matrizPeças[j][1];
                                    matrizLocaisUtilizados[k][l]=1;
                                }
                            }
                        }
                        int primeirok;
                        int primeirol;
                        while(Altura==false && Largura==false){
                            ArrayList ultimoLargura = new ArrayList();
                             //for verificador da largura  disponivel 
                            for(int k=0;k<alturaMatrizGrande;k++){
                                int somadorLargura=0;
                                for(int l=0;l<larguraMatrizGrande;l++){
                                    if(matrizLocaisUtilizados[k][l]!=1){
                                        somadorLargura=0;
                                    }
                                    if(matrizLocaisUtilizados[k][l]==1){
                                        somadorLargura=somadorLargura+1;
                                        if(somadorLargura==matrizPeças[j][3]){
                                            Largura=true;
                                            
                                            if(Largura=true){
                                                ultimoLargura.add(k);
                                                ultimoLargura.add(l);
                                                break;
                                            }
                                        }
                                    }

                                }
                            }

                            primeirok=ultimoLargura.get(0)-matrizPeças[j][3];
                            primeirol=ultimoLargura.get(1)-matrizPeças[j][3];

                            //for verificador da altura disponivel 
                            for(int k=primeirok;k<matrizPeças[j][2];k++){
                                int somadorAltura=0;
                            
                                for(int l=primeirol;l<matrizPeças[j][2];l++){
                                    if(matrizLocaisUtilizados[k][l]!=1){
                                        somadorAltura=0;
                                    }
                                    if(matrizAuxiliar[k][l]==1){
                                        somadorAltura=somadorAltura+1;
                                        if(somadorAltura==matrizPeças[j][3]){
                                            var ultimoAltura = new ArrayList();
                                            ultimoAltura.add(k);
                                            ultimoAltura.add(l);
                                            Altura=true;
                                            break;
                                        }
                                    }
                                }               
                            }

                        }

                     
                        for(int k=primeirok;k<matrizPeças[j][2];k++){
                            for(int l=primeirol;l<matrizPeças[j][2];l++){
                                matrizGrande[k][l]=matrizPeças[j][1];
                                matrizLocaisUtilizados[k][l]=1;
                            }               
                        }


                    }
                }

            
                    }            
                }
            
        

        for(int j=0;j<alturaMatrizGrande;j++){
            for(int k=0;k<larguraMatrizGrande;k++){
                System.out.print(matrizGrande[j][k]+ " ");   
            }
                System.out.print("}");
                System.out.println(" ");
                }
     
    }
}        
                    

                         
                  
                
                    
 


