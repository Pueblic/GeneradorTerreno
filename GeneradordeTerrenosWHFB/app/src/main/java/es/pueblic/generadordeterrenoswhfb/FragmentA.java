package es.pueblic.generadordeterrenoswhfb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends Fragment {
    TextView tvEsceno;
    Button btGenerar;

    int numRiosLagos;
    int numArroyos;
    int numPantanos;
    int numMurosSetosVallas;
    int numBosques;
    int numBosqueColina;
    int numColinas;
    int numGranjas;
    int numPueblos;
    int numRuinas;
    int numEdificios;

    String resultado;

    Random random;
    
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        random = new Random();
        tvEsceno = view.findViewById(R.id.tvEsceno);
        btGenerar = view.findViewById(R.id.btGenerar);
        btGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generarEsceno();
            }
        });
        return view;
    }

    private void generarEsceno() {
        do {
            numRiosLagos = 0;
            numArroyos = 0;
            numPantanos = 0;
            numMurosSetosVallas = 0;
            numBosques = 0;
            numBosqueColina = 0;
            numColinas = 0;
            numGranjas = 0;
            numPueblos = 0;
            numRuinas = 0;
            numEdificios = 0;

            resultado = "";
            tvEsceno.setText("");

            int d3 = random.nextInt(3) + 1;
            int numElementos = 5 + d3;

            switch (numElementos){
                case 6:
                    generarSeis();
                    break;
                case 7:
                    generarSiete();
                    break;
                case 8:
                    generarOcho();
            }

        } while (
                numRiosLagos > 1
                        || numArroyos > 1
                        || numPantanos > 1
                        || numMurosSetosVallas > 2
                        || numBosques > 2
                        || numBosqueColina > 2
                        || numColinas > 2
                        || numGranjas > 2
                        || numPueblos > 2
                        || numRuinas > 2
                        || numEdificios > 2
                );
        tvEsceno.setText(resultado);
    }

    private void generarSeis() {
        resultado += "Primera sección: " + generarElemento(tirar2d6());
        resultado += "Segunda sección: " + generarElemento(tirar2d6());
        resultado += "Tercera sección: " + generarElemento(tirar2d6());
        resultado += "Cuarta sección: " + generarElemento(tirar2d6());
        resultado += "Quinta sección: " + generarElemento(tirar2d6());
        resultado += "Sexta sección: " + generarElemento(tirar2d6());
    }
    private void generarSiete() {
        resultado += "Primera sección: " + generarElemento(tirar2d6());
        resultado += "Segunda sección: " + generarElemento(tirar2d6());
        resultado += "Tercera sección: " + generarElemento(tirar2d6());
        resultado += "Cuarta sección: " + generarElemento(tirar2d6());
        resultado += "Quinta sección: " + generarElemento(tirar2d6());
        resultado += "Sexta sección: " + generarElemento(tirar2d6());
        resultado += "Primer vértice: " + generarElemento(tirar2d6());
    }
    private void generarOcho() {
        resultado += "Primera sección: " + generarElemento(tirar2d6());
        resultado += "Segunda sección: " + generarElemento(tirar2d6());
        resultado += "Tercera sección: " + generarElemento(tirar2d6());
        resultado += "Cuarta sección: " + generarElemento(tirar2d6());
        resultado += "Quinta sección: " + generarElemento(tirar2d6());
        resultado += "Sexta sección: " + generarElemento(tirar2d6());
        resultado += "Primer vértice: " + generarElemento(tirar2d6());
        resultado += "Segundo vértice: " + generarElemento(tirar2d6());
    }

    private String generarElemento (int tirada){
        String elemento = "";
        switch (tirada){
            case 2:
                elemento = "un río o lago.\n\n";
                numRiosLagos++;
                break;
            case 3:
                elemento = "un arroyo.\n\n";
                numArroyos++;
                break;
            case 4:
                elemento = "un pantano.\n\n";
                numPantanos++;
                break;
            case 5:
                elemento = "muros, setos o vallas.\n\n";
                numMurosSetosVallas++;
                break;
            case 6:
                elemento = "un bosque.\n\n";
                numBosques++;
                break;
            case 7:
                elemento = "un bosque o una colina.\n\n";
                numBosqueColina++;
                break;
            case 8:
                elemento = "una colina.\n\n";
                numColinas++;
                break;
            case 9:
                elemento = "una granja.\n\n";
                numGranjas++;
                break;
            case 10:
                elemento = "un pueblo.\n\n";
                numPueblos++;
                break;
            case 11:
                elemento = "unas ruinas.\n\n";
                numRuinas++;
                break;
            case 12:
                elemento = "un edificio grande.\n\n";
                numEdificios++;
        }
    return elemento;
    }

    private int tirar2d6(){
        int primerDado = random.nextInt(6) + 1;
        int segundoDado = random.nextInt(6) + 1;
        int resultado = primerDado + segundoDado;
        return resultado;
    }
}
