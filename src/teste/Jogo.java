package teste;

public class Jogo {
    private Tabuleiro board;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada=0;
    
    public Jogo(){
        board = new Tabuleiro();
        Jogar(board);
        jogada = new int[2];
    }
    
    public void Jogar(Tabuleiro board){
        do{
            rodada++;
            System.out.println("Rodada "+rodada);
            board.exibe();
            terminar = board.setPosicao();
            
            if(!terminar){
                board.abrirVizinhas();
                terminar = board.ganhou();
            }
            
        }while(!terminar);
        
        if(!board.ganhou()){
            System.out.println("Você encontrou uma mina! Tente novamente!");
            board.exibeMinas();
        } else {
            System.out.println("Parabéns  "+rodada+" rodadas");
            board.exibeMinas();
        }
    }
}