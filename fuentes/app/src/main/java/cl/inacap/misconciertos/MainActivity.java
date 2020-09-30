//package
package cl.inacap.misconciertos;
//imports
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
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
    private int dia,mes,ano;
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
        fechaEventoBtn.setOnClickListener(this);
    }
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
    private void resultadoFechaTxt(String s) {
    }
}