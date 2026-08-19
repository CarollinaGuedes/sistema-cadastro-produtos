package SistemaDeLojaComProdutosVariados;

public enum StatusProduto {
    ESTOQUE,
    EM_TRANSITO,
    SEM_PREVISAO;


    public String getDescricao() {
        switch (this) {
            case ESTOQUE: return "Em Estoque";
            case EM_TRANSITO: return "Em Trânsito";
            case SEM_PREVISAO: return "Sem Previsão";
            default: return "Desconhecido";
        }
    }
}
