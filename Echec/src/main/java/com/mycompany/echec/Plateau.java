package com.mycompany.echec;

public class Plateau {
    
    //Attributs
    public static Pieces grille[][] = new Pieces[8][8];
    
    //Constructeurs
    
    //Methodes
    public void afficherGrille(){ //affichage de l'echequier avec les pièces
        System.out.println("\n _________________________________Y=");
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(" ┃ ");
                if (grille[i][j] == null){
                    System.out.print(".");
                }
                else if(grille[i][j].getCouleur() == false){
                    if(grille[i][j] instanceof Roi){
                        System.out.print("♚");
                    }
                    if(grille[i][j] instanceof Dame){
                        System.out.print("♛");
                    }
                    if(grille[i][j] instanceof Fou){
                        System.out.print("♝");
                    }
                    if(grille[i][j] instanceof Cavalier){
                        System.out.print("♞");
                    }
                    if(grille[i][j] instanceof Tour){
                        System.out.print("♜");
                    }
                    if(grille[i][j] instanceof Pion){
                        System.out.print("♟");
                    }
                }
                else if(grille[i][j].getCouleur() == true){
                    if(grille[i][j] instanceof Roi){
                        System.out.print("♔");
                    }
                    if(grille[i][j] instanceof Dame){
                        System.out.print("♕");
                    }
                    if(grille[i][j] instanceof Fou){
                        System.out.print("♗");
                    }
                    if(grille[i][j] instanceof Cavalier){
                        System.out.print("♘");
                    }
                    if(grille[i][j] instanceof Tour){
                        System.out.print("♖");
                    }
                    if(grille[i][j] instanceof Pion){
                        System.out.print("♙");
                    }
                }
            }
            System.out.println(" ┃ "+(i+1));
        }
        System.out.println("X= 1   2   3   4   5   6   7   8\n");
    }
    
    /*public Pieces getPieceEn(int x, int y, Plateau plateau){
        return plateau.grille[x][y];
    }*/
    /*public void bouger(int x1, int y1, int x2, int y2){
        Pieces toto = getPieceEn(x1, y1,);
        
    }*/
    
    /*public Pieces[][] getGrille(){
        return this.grille;
    }
    public void receiveGrille(Pieces[][] grille){
        this.grille = grille;
    }*/
}