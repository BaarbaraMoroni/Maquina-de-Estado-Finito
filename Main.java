import java.util.Scanner;

public class Automato {
  private static final int QTD_ESTADOS = 3;
  private static final int QTD_SIMBOLOS = 2;
  private static final int[][] TABELA_TRANSICAO = {
      {1, 2},
      {2, 2},
      {2, 2}
  };
  private static final int ESTADO_INICIAL = 0;
  private static final int[] ESTADOS_ACEITACAO = {1};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite a cadeia de entrada: ");
    String entrada = scanner.nextLine();

    int estadoAtual = ESTADO_INICIAL;
    for (int i = 0; i < entrada.length(); i++) {
      int simbolo = Integer.parseInt(String.valueOf(entrada.charAt(i)));
      estadoAtual = TABELA_TRANSICAO[estadoAtual][simbolo];
    }

    boolean aceitacao = false;
    for (int estadoAceitacao : ESTADOS_ACEITACAO) {
      if (estadoAtual == estadoAceitacao) {
        aceitacao = true;
        break;
      }
    }

    if (aceitacao) {
      System.out.println("A cadeia de entrada foi ACEITA pelo autômato.");
    } else {
      System.out.println("A cadeia de entrada foi REJEITADA pelo autômato.");
    }
  }
}