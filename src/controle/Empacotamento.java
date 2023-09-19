package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Empacotamento {

    //metodo serialização: gravando o objetos no arquivo binário "como o nome do arquivo que foi escrito"
    public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();

            try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq))) {
                objOutput.writeObject(lista);
            }

        } catch (IOException erro) {
            System.out.printf("Erro: %s", erro.getMessage());
        }
    }

    // metodo de desserialização: recuperando os objetos gravados no arquivo binário "como o nome do arquivo que foi escrito"
    public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
        ArrayList<Object> lista = new ArrayList();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq))) {
                    lista = (ArrayList<Object>) objInput.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException erro1) {
            System.out.printf("Erro: %s", erro1.getMessage());
        }

        return (lista);
    }

}
