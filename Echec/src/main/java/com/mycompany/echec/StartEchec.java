package com.mycompany.echec;

import static com.mycompany.echec.Plateau.grille;
import java.util.*;

public class StartEchec {
    public static void main (String [] args){
        Scanner keyboard = new Scanner(System.in);
        
        Plateau plateau = new Plateau(); //création d'un Plateau "plateau"
        
        plateau.grille[0][0] = new Tour(false); //placement des noirs
        plateau.grille[0][1] = new Cavalier(false);
        plateau.grille[0][2] = new Fou(false);
        plateau.grille[0][3] = new Dame(false);
        plateau.grille[0][4] = new Roi(false);
        plateau.grille[0][5] = new Fou(false);
        plateau.grille[0][6] = new Cavalier(false);
        plateau.grille[0][7] = new Tour(false);
        for(int i=0; i<8; i++){
            plateau.grille[1][i] = new Pion(false);
        }
        plateau.grille[7][0] = new Tour(true); //placement des blancs
        plateau.grille[7][1] = new Cavalier(true);
        plateau.grille[7][2] = new Fou(true);
        plateau.grille[7][3] = new Dame(true);
        plateau.grille[7][4] = new Roi(true);
        plateau.grille[7][5] = new Fou(true);
        plateau.grille[7][6] = new Cavalier(true);
        plateau.grille[7][7] = new Tour(true);
        for(int i=0; i<8; i++){
            plateau.grille[6][i] = new Pion(true);
        }
        
        plateau.afficherGrille();
        
        int y1 = 0, x1 = 0, y2 = 0, x2 = 0;
        int ok = 0, choix = 0;
        
        while(ok >= 0){ //partie en cour
            while(ok == 0){ //joueur blanc
                ok = 0;
                while(ok != 5){ //sélection position
                    ok = 0;
                    System.out.println("\n□□□ Joueur Blanc □□□\nVeuillez selectionner les coordonnées de votre pièce à bouger");
                    System.out.print("X : ");
                    x1 = keyboard.nextInt() - 1;
                    if((x1 >= 0) && (x1 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.print("Y : ");
                    y1 = keyboard.nextInt() - 1;
                    if((y1 >= 0) && (y1 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.println("Veuillez selectionner les coordonnées de destination");
                    System.out.print("X : ");
                    x2 = keyboard.nextInt() - 1;
                    if((x2 >= 0) && (x2 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.print("Y : ");
                    y2 = keyboard.nextInt() - 1;
                    if((y2 >= 0) && (y2 <= 7)){
                        ok = ok + 1;
                    }
                    if(grille[y1][x1] != null){
                        if(grille[y1][x1].getCouleur() == true){
                            ok = ok + 1;
                        }
                    }
                }
                if(ok == 5){ //déplacement d'une piece
                    if(grille[y1][x1] instanceof Roi){ //roi
                        if(((Math.abs(x2 - x1) == 1) && (y2 - y1 == 0)) || ((Math.abs(y2 - y1) == 1) && (x2 - x1 == 0)) || ((Math.abs(x2 - x1) == 1) && (Math.abs(y2 - y1) == 1) && (Math.abs(x2 - x1) + Math.abs(y2 - y1) == 2))){
                            if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Roi(true);
                            }
                            else{
                                ok = 0;
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Dame){ //dame
                        if(Math.abs(x2 - x1) == Math.abs(y2 - y1)){ //mode fou
                            if((x2 < x1) && (y2 < y1)){ //haut-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 < y1)){ //haut-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 < x1) && (y2 > y1)){ //bas-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 > y1)){ //bas-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else if(x2 - x1 == 0 || y2 - y1 == 0){ //mode tour
                            if(y2 - y1 < 0){ //haut
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(y2 - y1 > 0){ //bas
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 < 0){ //gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 > 0){ //droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Fou){ //fou
                        if(Math.abs(x2 - x1) == Math.abs(y2 - y1)){
                            if((x2 < x1) && (y2 < y1)){ //haut-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 < y1)){ //haut-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 < x1) && (y2 > y1)){ //bas-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 > y1)){ //bas-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Cavalier){ //cavalier
                        if((x2 - x1 != 0) && (y2 - y1 != 0) && (Math.abs(x2 - x1) + Math.abs(y2 - y1) == 3)){
                            if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Cavalier(true);
                            }
                            else{
                                ok = 0;
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Tour){ //tour
                        if(x2 - x1 == 0 || y2 - y1 == 0){
                            if(y2 - y1 < 0){ //haut
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(y2 - y1 > 0){ //bas
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 < 0){ //gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 > 0){ //droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == false)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(true);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Pion){ //pion
                        if(((y2 - y1 == -1) || ((y1 == 6) && (y2 - y1 == -2))) && (x2 - x1 == 0)){ //en avant
                            if(plateau.grille[y2][x2] == null){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Pion(true);
                            }
                        }
                        else if((Math.abs(x2 - x1) == 1) && (y2 - y1) == -1 && plateau.grille[y2][x2] != null){ //attaque
                            if(plateau.grille[y2][x2].getCouleur() == false){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Pion(true);
                            }
                        }
                        else{
                            ok = 0;
                        }
                        if(ok != 0 && y2 == 0){ //promotion
                            choix = 0;
                            while(choix == 0){
                                System.out.print("Quelle promotion votre pion doit-il recevoir ?\n1. Tour\n2. Cavalier\n3. Fou\n4. Dame\n? : ");
                                choix = keyboard.nextInt();
                                switch(choix){
                                    case 1:
                                        plateau.grille[y2][x2] = new Tour(true);
                                        break;
                                    case 2:
                                        plateau.grille[y2][x2] = new Cavalier(true);
                                        break;
                                    case 3:
                                        plateau.grille[y2][x2] = new Fou(true);
                                        break;
                                    case 4:
                                        plateau.grille[y2][x2] = new Dame(true);
                                        break;
                                    default:
                                        choix = 0;
                                        break;
                                }
                            }
                        }
                    }
                    else{ //probleme
                        ok = 0;
                    }
                }
            }
            plateau.afficherGrille();

            ok = -1;
            for(int i=0; i<8; i++){//roi noir en vie ?
                for(int j=0; j<8; j++){
                    if(plateau.grille[i][j] instanceof Roi && plateau.grille[i][j].getCouleur() == false){
                        ok = 0;
                    }
                }
            }

            while(ok == 0){ //joueur noir
                ok = 0;
                while(ok != 5){
                    ok = 0;
                    System.out.println("\n■■■ Joueur Noir ■■■\nVeuillez selectionner les coordonnées de votre pièce à bouger");
                    System.out.print("X : ");
                    x1 = keyboard.nextInt() - 1;
                    if((x1 >= 0) && (x1 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.print("Y : ");
                    y1 = keyboard.nextInt() - 1;
                    if((y1 >= 0) && (y1 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.println("Veuillez selectionner les coordonnées de destination");
                    System.out.print("X : ");
                    x2 = keyboard.nextInt() - 1;
                    if((x2 >= 0) && (x2 <= 7)){
                        ok = ok + 1;
                    }
                    System.out.print("Y : ");
                    y2 = keyboard.nextInt() - 1;
                    if((y2 >= 0) && (y2 <= 7)){
                        ok = ok + 1;
                    }
                    if(grille[y1][x1] != null){
                        if(grille[y1][x1].getCouleur() == false){
                            ok = ok + 1;
                        }
                    }
                }
                if(ok == 5){
                    if(grille[y1][x1] instanceof Roi){
                        if(((Math.abs(x2 - x1) == 1) && (y2 - y1 == 0)) || ((Math.abs(y2 - y1) == 1) && (x2 - x1 == 0)) || ((Math.abs(x2 - x1) == 1) && (Math.abs(y2 - y1) == 1) && (Math.abs(x2 - x1) + Math.abs(y2 - y1) == 2))){
                            if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Roi(false);
                            }
                            else{
                                ok = 0;
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Dame){
                        if(Math.abs(x2 - x1) == Math.abs(y2 - y1)){
                            if((x2 < x1) && (y2 < y1)){ //haut-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 < y1)){ //haut-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 < x1) && (y2 > y1)){ //bas-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 > y1)){ //bas-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else if(x2 - x1 == 0 || y2 - y1 == 0){
                            if(y2 - y1 < 0){ //haut
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(y2 - y1 > 0){ //bas
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 < 0){ //gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 > 0){ //droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Dame(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Fou){
                        if(Math.abs(x2 - x1) == Math.abs(y2 - y1)){
                            if((x2 < x1) && (y2 < y1)){ //haut-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 < y1)){ //haut-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 < x1) && (y2 > y1)){ //bas-gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if((x2 > x1) && (y2 > y1)){ //bas-droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Fou(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Cavalier){
                        if((x2 - x1 != 0) && (y2 - y1 != 0) && (Math.abs(x2 - x1) + Math.abs(y2 - y1) == 3)){
                            if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Cavalier(false);
                            }
                            else{
                                ok = 0;
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Tour){
                        if(x2 - x1 == 0 || y2 - y1 == 0){
                            if(y2 - y1 < 0){ //haut
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1-(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(y2 - y1 > 0){ //bas
                                for(int i=0; i<Math.abs(y2-y1)-1; i++){
                                    if(plateau.grille[y1+(i+1)][x1] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 < 0){ //gauche
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1-(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                            if(x2 - x1 > 0){ //droite
                                for(int i=0; i<Math.abs(x2-x1)-1; i++){
                                    if(plateau.grille[y1][x1+(i+1)] != null){
                                        ok = 0;
                                    }
                                }
                                if(ok != 0){
                                    if((plateau.grille[y2][x2] == null) || (plateau.grille[y2][x2].getCouleur() == true)){
                                        plateau.grille[y1][x1] = null;
                                        plateau.grille[y2][x2] = new Tour(false);
                                    }
                                    else{
                                        ok = 0;
                                    }
                                }
                            }
                        }
                        else{
                            ok = 0;
                        }
                    }
                    else if(grille[y1][x1] instanceof Pion){
                        if(((y2 - y1 == 1) || ((y1 == 1) && (y2 - y1 == 2))) && (x2 - x1 == 0)){
                            if(plateau.grille[y2][x2] == null){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Pion(false);
                            }
                        }
                        else if((Math.abs(x2 - x1) == 1) && (y2 - y1) == 1 && plateau.grille[y2][x2] != null){
                            if(plateau.grille[y2][x2].getCouleur() == true){
                                plateau.grille[y1][x1] = null;
                                plateau.grille[y2][x2] = new Pion(false);
                            }
                        }
                        else{
                            ok = 0;
                        }
                        if(ok != 0 && y2 == 7){
                            choix = 0;
                            while(choix == 0){
                                System.out.print("Quelle promotion votre pion doit-il recevoir ?\n1. Tour\n2. Cavalier\n3. Fou\n4. Dame\n? : ");
                                choix = keyboard.nextInt();
                                switch(choix){
                                    case 1:
                                        plateau.grille[y2][x2] = new Tour(false);
                                        break;
                                    case 2:
                                        plateau.grille[y2][x2] = new Cavalier(false);
                                        break;
                                    case 3:
                                        plateau.grille[y2][x2] = new Fou(false);
                                        break;
                                    case 4:
                                        plateau.grille[y2][x2] = new Dame(false);
                                        break;
                                    default:
                                        choix = 0;
                                        break;
                                }
                            }
                        }
                    }
                    else{
                        ok = 0;
                    }
                }
            }
            if(ok != -1){
                plateau.afficherGrille();

                ok = -2;
                for(int i=0; i<8; i++){//roi blanc en vie ?
                    for(int j=0; j<8; j++){
                        if(plateau.grille[i][j] instanceof Roi && plateau.grille[i][j].getCouleur() == true){
                            ok = 0;
                        }
                    }
                }
            }
        }
        if(ok == -1){
            System.out.print("Les Blancs ont gagnés !");
        }
        else if(ok == -2){
            System.out.print("Les Noirs ont gagnés !");
        }
    }
}
