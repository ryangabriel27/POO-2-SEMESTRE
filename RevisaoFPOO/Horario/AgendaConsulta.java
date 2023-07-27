package RevisaoFPOO.Horario;

public class AgendaConsulta {

    String nomeCliente;
    String horarioDesejado;
    String dataDesejada;
    String agendamento;

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getHorarioDesejado() {
        return horarioDesejado;
    }
    public void setHorarioDesejado(String horarioDesejado) {
        this.horarioDesejado = horarioDesejado;
    }
    public String getDataDesejada() {
        return dataDesejada;
    }
    public void setDataDesejada(String dataDesejada) {
        this.dataDesejada = dataDesejada;
    }

    public String getAgendamento() {
        agendamento = dataDesejada + horarioDesejado;
        return agendamento;
    }
    
}
