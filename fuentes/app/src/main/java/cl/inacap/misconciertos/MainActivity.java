//package
package cl.inacap.misconciertos;
//imports
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import cl.inacap.misconciertos.dto.Evento;
//class
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //references
    private EditText nombreArtistaTxt;
    private EditText resultadoFechaTxt;
    private EditText valorEntradaTxt;
    private Spinner generoSpi;
    private Spinner calificacionSpi;
    private Button fechaEventoBtn;
    private Button registrarBtn;
    private ListView conciertosLv;
    private int dia,mes,ano;
    private List<Evento> valores = new ArrayList<Evento>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this
        this.nombreArtistaTxt = findViewById(R.id.nombreArtistaTxt);
        this.resultadoFechaTxt = findViewById(R.id.resultadoFechaTxt);
        this.valorEntradaTxt = findViewById(R.id.valorEntradaTxt);
        this.generoSpi = findViewById(R.id.generoSpi);
        this.calificacionSpi = findViewById(R.id.calificacionSpi);
        this.fechaEventoBtn = findViewById(R.id.fechaEventoBtn);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        this.conciertosLv = findViewById(R.id.conciertosLv);
        fechaEventoBtn.setOnClickListener(this);
        //toast and listener
        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //list of errors
                List<String> errores = new ArrayList<>();
                String valorStr = valorEntradaTxt.getText().toString().trim();
                int valor=0;
                //nombre de artista
                if (nombreArtistaTxt.getText().toString().trim().isEmpty()) {
                    errores.add("Debe Ingresar Un Nombre De Artista Valido");
                }
                //valor de entrada
                try {
                    valor = Integer.parseInt(valorStr);
                    if (valor < 1 || valor > 999999) {
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex) {
                    errores.add("-El Valor De Entrada Debe Ser Mayor A 0 Y Menor Que 999999");
                }
                //errores
                if (errores.isEmpty()) {
                    //valor de entrada
                    Evento va = new Evento();
                    va.setValor(valor);
                    valores.add(va);
                } else {
                    mostrarErrores(errores);
                }
            }
        });
    }
    //calendario
    @Override
    public void onClick(View v) {
        if(v==fechaEventoBtn) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    resultadoFechaTxt.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
    //mostrar errores en la app
    private void mostrarErrores(List <String> errores) {
        //1. generar una cadena de texto con los errores
        String mensaje = "";
        for (String e: errores) {
            mensaje+= "-" + e + "\n";
        }
        //2. mostrar un mensaje de alerta
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
        //chaining (encademaniento)
        alertBuilder
                .setTitle("Error De Validacion") //define el titulo
                .setMessage(mensaje) //define el mensaje a mostrar
                .setPositiveButton("Agregar", null) //agrega el boton
                .create() //crear el alert
                .show(); //lo muestra
    }
}
//End