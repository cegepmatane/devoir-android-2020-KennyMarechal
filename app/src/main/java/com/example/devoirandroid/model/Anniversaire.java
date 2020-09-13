package com.example.devoirandroid.model;

import java.util.HashMap;

public class Anniversaire {

    protected int id;
    protected String titre;
    protected String date;
    protected String heure;
    protected String description;
    protected String url;

    public Anniversaire(int id, String titre, String date, String heure, String description, String url) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.url = url;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String ,String> obtenirAnniversairePourAfficher(){
        HashMap<String,String> anniversairePourAfficher = new HashMap<String,String>();
        anniversairePourAfficher.put("id", ""+this.getId());
        anniversairePourAfficher.put("titre", this.getTitre());
        anniversairePourAfficher.put("date", this.getDate());

        return anniversairePourAfficher;
    }
}
