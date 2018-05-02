package com.mycompany.echec;

public class Pieces {
    private boolean couleur;
    //private int x;
    //private int y;
    private String typePieces;
    
    //Constructeur
    public Pieces(boolean couleur, String type){
        this.typePieces = type;
        this.couleur = couleur;
        //this.x = y;
        //this.y = x;
    }
    
    public boolean getCouleur(){
        return this.couleur;
    }
}
