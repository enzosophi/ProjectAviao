package com.example.projectaviao;

public class Viagem {

    public static final String TAG="Viagem Table";

    private int id;
    private String partida;
    private String destino;
    private String situacao;
    private String dataViagem;
    private String horarioViagem;
    private int idAero;
    private int idUsuario;
    private int quantidadePassageiros;

    // Construtor da classe
    public Viagem(int id, String partida, String destino, String situacao, String dataViagem, String horarioViagem, int idAero, int idUsuario, int quantidadePassageiros) {
        this.id = id;
        this.partida = partida;
        this.destino = destino;
        this.situacao = situacao;
        this.dataViagem = dataViagem;
        this.horarioViagem = horarioViagem;
        this.idAero = idAero;
        this.idUsuario = idUsuario;
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public String getHorarioViagem() {
        return horarioViagem;
    }

    public void setHorarioViagem(String horarioViagem) {
        this.horarioViagem = horarioViagem;
    }

    public int getIdAero() {
        return idAero;
    }

    public void setIdAero(int idAero) {
        this.idAero = idAero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }
}
