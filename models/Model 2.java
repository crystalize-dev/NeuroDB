import java.io.*;

import java.util.*;





public class Predict

{

   public static void __Exp_in_memory_performance_experi_MLP_11_6_2( double[] ContInputs, String[] CatInputs )

   {

     //"Input Variable" comment is added besides Input(Response) variables.



     int Cont_idx=0;

     int Cat_idx=0;

     double _CORRECT3__ = ContInputs[Cont_idx++]; //Input Variable

     double _CORRECT2__ = ContInputs[Cont_idx++]; //Input Variable

     double _CORRECT1__ = ContInputs[Cont_idx++]; //Input Variable

     double _STRESS_R__ = ContInputs[Cont_idx++]; //Input Variable

     String _GROUP__ = CatInputs[Cat_idx++]; //Input Variable

     String _TIME__ = CatInputs[Cat_idx++]; //Input Variable

     String _PAID__ = CatInputs[Cat_idx++]; //Input Variable

     String __statist_PredCat="";

    String [] __statist_DCats = new String[2];

    __statist_DCats[0]= "FEMALE";

    __statist_DCats[1]= "MALE";



    double __statist_ConfLevel=3.0E-300;



    double[] __statist_max_input = new double[4];

    __statist_max_input[0]= 9.00000000000000e+000;

    __statist_max_input[1]= 9.00000000000000e+000;

    __statist_max_input[2]= 1.90000000000000e+001;

    __statist_max_input[3]= 1.62500000000000e+001;



    double[] __statist_min_input = new double[4];

    __statist_min_input[0]= 0.00000000000000e+000;

    __statist_min_input[1]= 1.00000000000000e+000;

    __statist_min_input[2]= 3.00000000000000e+000;

    __statist_min_input[3]= 1.41000000000000e+000;





    double[][] __statist_i_h_wts = new double[6][11];



    __statist_i_h_wts[0][0]=-2.98390629939052e+000;

    __statist_i_h_wts[0][1]=3.81175825491869e+000;

    __statist_i_h_wts[0][2]=1.55593704821623e+000;

    __statist_i_h_wts[0][3]=-5.73294654463619e+000;

    __statist_i_h_wts[0][4]=1.92736342182829e-001;

    __statist_i_h_wts[0][5]=-1.56900892428764e+000;

    __statist_i_h_wts[0][6]=-6.79501960497254e-001;

    __statist_i_h_wts[0][7]=-6.57863564795007e-001;

    __statist_i_h_wts[0][8]=9.82130732969656e-002;

    __statist_i_h_wts[0][9]=4.74415481417099e+000;

    __statist_i_h_wts[0][10]=-6.12468743334837e+000;



    __statist_i_h_wts[1][0]=-3.45730774680916e+000;

    __statist_i_h_wts[1][1]=4.72619430067142e+000;

    __statist_i_h_wts[1][2]=1.00287462014229e+000;

    __statist_i_h_wts[1][3]=-7.43104871858263e+000;

    __statist_i_h_wts[1][4]=1.10057788630756e-001;

    __statist_i_h_wts[1][5]=-8.17627490213525e-001;

    __statist_i_h_wts[1][6]=-4.79537385270466e-001;

    __statist_i_h_wts[1][7]=-2.12774037721738e+000;

    __statist_i_h_wts[1][8]=1.87637518179810e+000;

    __statist_i_h_wts[1][9]=7.59048936754483e+000;

    __statist_i_h_wts[1][10]=-8.29271216570958e+000;



    __statist_i_h_wts[2][0]=-1.51627371471170e-001;

    __statist_i_h_wts[2][1]=3.72346104865231e+000;

    __statist_i_h_wts[2][2]=-2.25012726407132e+000;

    __statist_i_h_wts[2][3]=-6.78129695187082e+000;

    __statist_i_h_wts[2][4]=-1.02119650514853e+000;

    __statist_i_h_wts[2][5]=1.03207019191907e+000;

    __statist_i_h_wts[2][6]=2.50696860620365e-001;

    __statist_i_h_wts[2][7]=-5.64039179873907e-001;

    __statist_i_h_wts[2][8]=3.01544951292505e-001;

    __statist_i_h_wts[2][9]=2.76021193902149e+000;

    __statist_i_h_wts[2][10]=-2.74082055849944e+000;



    __statist_i_h_wts[3][0]=-2.09879560008592e-001;

    __statist_i_h_wts[3][1]=7.26632050504128e+000;

    __statist_i_h_wts[3][2]=-2.59008000446051e+000;

    __statist_i_h_wts[3][3]=-1.16464448793136e+001;

    __statist_i_h_wts[3][4]=-3.34476441371217e-001;

    __statist_i_h_wts[3][5]=5.79278709488198e-001;

    __statist_i_h_wts[3][6]=1.09749740022414e+000;

    __statist_i_h_wts[3][7]=7.24492800190306e-001;

    __statist_i_h_wts[3][8]=-1.54290302137387e+000;

    __statist_i_h_wts[3][9]=5.20519269620061e+000;

    __statist_i_h_wts[3][10]=-4.88510335746136e+000;



    __statist_i_h_wts[4][0]=-6.01667859279026e-002;

    __statist_i_h_wts[4][1]=-2.89275171478616e+000;

    __statist_i_h_wts[4][2]=7.71461430778726e-001;

    __statist_i_h_wts[4][3]=3.65618012441391e+000;

    __statist_i_h_wts[4][4]=1.70307222468404e-001;

    __statist_i_h_wts[4][5]=-6.77601480998805e-001;

    __statist_i_h_wts[4][6]=-2.74812668463512e-001;

    __statist_i_h_wts[4][7]=1.38776497240832e-001;

    __statist_i_h_wts[4][8]=-3.97954080017981e-001;

    __statist_i_h_wts[4][9]=-2.35890899687475e+000;

    __statist_i_h_wts[4][10]=1.75732947934556e+000;



    __statist_i_h_wts[5][0]=-1.28652483576071e-001;

    __statist_i_h_wts[5][1]=-1.39079769925359e+001;

    __statist_i_h_wts[5][2]=2.14154746174953e-001;

    __statist_i_h_wts[5][3]=1.72066987128392e+001;

    __statist_i_h_wts[5][4]=-1.24116291330349e+000;

    __statist_i_h_wts[5][5]=1.20103726111203e+000;

    __statist_i_h_wts[5][6]=6.71153824580724e-001;

    __statist_i_h_wts[5][7]=-9.64804529713446e-001;

    __statist_i_h_wts[5][8]=2.35283037206154e-001;

    __statist_i_h_wts[5][9]=-1.02374096471814e+001;

    __statist_i_h_wts[5][10]=1.01449700669965e+001;



    double[][] __statist_h_o_wts = new double[2][6];



    __statist_h_o_wts[0][0]=8.06351131288602e+000;

    __statist_h_o_wts[0][1]=1.33164886858267e+001;

    __statist_h_o_wts[0][2]=-3.69192339215585e+000;

    __statist_h_o_wts[0][3]=-1.05736776701110e+001;

    __statist_h_o_wts[0][4]=1.17793699130792e+000;

    __statist_h_o_wts[0][5]=7.17732125513031e+000;



    __statist_h_o_wts[1][0]=-8.06019963986151e+000;

    __statist_h_o_wts[1][1]=-1.32562445230418e+001;

    __statist_h_o_wts[1][2]=3.56495795755555e+000;

    __statist_h_o_wts[1][3]=1.06236331499362e+001;

    __statist_h_o_wts[1][4]=-1.15246712887204e+000;

    __statist_h_o_wts[1][5]=-7.10960991735380e+000;



    double[] __statist_hidden_bias = new double[6];

    __statist_hidden_bias[0]=-1.34471563419466e+000;

    __statist_hidden_bias[1]=-7.32707119154173e-001;

    __statist_hidden_bias[2]=5.41865673674172e-002;

    __statist_hidden_bias[3]=3.10064935812900e-001;

    __statist_hidden_bias[4]=-5.76105325684058e-001;

    __statist_hidden_bias[5]=-1.27113824671573e-001;



    double[] __statist_output_bias = new double[2];

    __statist_output_bias[0]=-7.81555667430747e+000;

    __statist_output_bias[1]=7.85630020666028e+000;



    double[] __statist_inputs = new double[11];



    double[] __statist_hidden = new double[6];



    double[] __statist_outputs = new double[2];

    __statist_outputs[0] = -1.0e+307;

    __statist_outputs[1] = -1.0e+307;



    __statist_inputs[0]=_CORRECT3__;

    __statist_inputs[1]=_CORRECT2__;

    __statist_inputs[2]=_CORRECT1__;

    __statist_inputs[3]=_STRESS_R__;



    if( _GROUP__.equals("CONTROL"))

    {

     __statist_inputs[4]=1;

    }

    else

    {

     __statist_inputs[4]=0;

    }



    if( _GROUP__.equals("EXPERMTL"))

    {

     __statist_inputs[5]=1;

    }

    else

    {

     __statist_inputs[5]=0;

    }



    if( _TIME__.equals("AFTER_1"))

    {

     __statist_inputs[6]=1;

    }

    else

    {

     __statist_inputs[6]=0;

    }



    if( _TIME__.equals("AFTER_2"))

    {

     __statist_inputs[7]=1;

    }

    else

    {

     __statist_inputs[7]=0;

    }



    if( _TIME__.equals("BEFORE"))

    {

     __statist_inputs[8]=1;

    }

    else

    {

     __statist_inputs[8]=0;

    }



    if( _PAID__.equals("NOT_PAID"))

    {

     __statist_inputs[9]=1;

    }

    else

    {

     __statist_inputs[9]=0;

    }



    if( _PAID__.equals("PAID"))

    {

     __statist_inputs[10]=1;

    }

    else

    {

     __statist_inputs[10]=0;

    }



    double __statist_delta=0;

    double __statist_maximum=1;

    double __statist_minimum=0;

    int __statist_ncont_inputs=4;



    /*scale continuous inputs*/

    for(int __statist_i=0;__statist_i < __statist_ncont_inputs;__statist_i++)

    {

     __statist_delta = (__statist_maximum-__statist_minimum)/(__statist_max_input[__statist_i]-__statist_min_input[__statist_i]);

     __statist_inputs[__statist_i] = __statist_minimum - __statist_delta*__statist_min_input[__statist_i]+ __statist_delta*__statist_inputs[__statist_i];

    }



    int __statist_ninputs=11;

    int __statist_nhidden=6;



    /*Compute feed forward signals from Input layer to hidden layer*/

    for(int __statist_row=0;__statist_row < __statist_nhidden;__statist_row++)

    {

      __statist_hidden[__statist_row]=0.0;

      for(int __statist_col=0;__statist_col < __statist_ninputs;__statist_col++)

      {

       __statist_hidden[__statist_row]= __statist_hidden[__statist_row] + (__statist_i_h_wts[__statist_row][__statist_col]*__statist_inputs[__statist_col]);

      }

     __statist_hidden[__statist_row]=__statist_hidden[__statist_row]+__statist_hidden_bias[__statist_row];

    }



    for(int __statist_row=0;__statist_row < __statist_nhidden;__statist_row++)

    {

     if(__statist_hidden[__statist_row]>100.0)

     {

      __statist_hidden[__statist_row] = 1.0;

     }

     else

     {

      if(__statist_hidden[__statist_row]<-100.0)

      {

       __statist_hidden[__statist_row] = 0.0;

      }

      else

      {

      __statist_hidden[__statist_row] = 1.0/(1.0+Math.exp(-__statist_hidden[__statist_row]));

      }

    }

  }



    int __statist_noutputs=2;



    /*Compute feed forward signals from hidden layer to output layer*/

    for(int __statist_row2=0;__statist_row2 < __statist_noutputs;__statist_row2++)

    {

     __statist_outputs[__statist_row2]=0.0;

    for(int __statist_col2=0;__statist_col2 < __statist_nhidden;__statist_col2++)

      {

       __statist_outputs[__statist_row2]= __statist_outputs[__statist_row2] + (__statist_h_o_wts[__statist_row2][__statist_col2]*__statist_hidden[__statist_col2]);

      }

     __statist_outputs[__statist_row2]=__statist_outputs[__statist_row2]+__statist_output_bias[__statist_row2];

    }





    double __statist_sum=0.0;

    double __statist_maxIndex=0;

    for(int __statist_jj=0;__statist_jj < __statist_noutputs;__statist_jj++)

    {

     if(__statist_outputs[__statist_jj] > 200)

     {

      double __statist_max=__statist_outputs[1];

      __statist_maxIndex=0;

     for(int __statist_ii=0;__statist_ii < __statist_noutputs;__statist_ii++)

    {

      if(__statist_outputs[__statist_ii] > __statist_max)

      {

        __statist_max = __statist_outputs[__statist_ii];

        __statist_maxIndex = __statist_ii;

      }

     }



     for(int __statist_kk=0;__statist_kk < __statist_noutputs;__statist_kk++)

    {

      if(__statist_kk==__statist_maxIndex)

      {

        __statist_outputs[__statist_jj]=1.0;

      }

      else

      {

        __statist_outputs[__statist_kk]=0.0;

      }

     }

    }

    else

    {

     __statist_outputs[__statist_jj] = Math.exp(__statist_outputs[__statist_jj]);

     __statist_sum = __statist_sum + __statist_outputs[__statist_jj];

    }

   }

     for(int __statist_ll=0;__statist_ll < __statist_noutputs;__statist_ll++)

    {

     if(__statist_sum != 0)

     {

      __statist_outputs[__statist_ll] = __statist_outputs[__statist_ll]/__statist_sum;

     }

    }



    int __statist_PredIndex=1;

    for(int __statist_ii=0;__statist_ii < __statist_noutputs;__statist_ii++)

    {

     if(__statist_ConfLevel < __statist_outputs[__statist_ii])

     {

      __statist_ConfLevel=__statist_outputs[__statist_ii];

      __statist_PredIndex=__statist_ii;

     }

    }



    __statist_PredCat = __statist_DCats[__statist_PredIndex];



      System.out.println(" Predicted Category = " + __statist_PredCat);

      System.out.println(" Confidence Level = " + __statist_ConfLevel);



   }



   public static void main (String[] args) {

     int argID = 0;

     double[] ContInputs = new double[4];

     int contID = 0;

     String[] CatInputs = new String[3];

     int catID = 0;



     if (args.length >= 7)

     {

       ContInputs[contID++] =  Double.parseDouble(args[argID++]);

       ContInputs[contID++] =  Double.parseDouble(args[argID++]);

       ContInputs[contID++] =  Double.parseDouble(args[argID++]);

       ContInputs[contID++] =  Double.parseDouble(args[argID++]);

       CatInputs[catID++] = args[argID++];

       CatInputs[catID++] = args[argID++];

       CatInputs[catID++] = args[argID++];

     }

     else

     {

       String Comment = "";

       String Comment1 = "**************************************************************************\n";

       Comment += Comment1;

       String Comment2 = "Please enter at least 7 command line parameters in the following order for \nthe program to Predict.\n";

       Comment += Comment2;

       Comment += Comment1;

       String Comment3 = "CORRECT3  Type - double (or) integer\n";

       Comment += Comment3;

       String Comment4 = "CORRECT2  Type - double (or) integer\n";

       Comment += Comment4;

       String Comment5 = "CORRECT1  Type - double (or) integer\n";

       Comment += Comment5;

       String Comment6 = "STRESS_R  Type - double (or) integer\n";

       Comment += Comment6;

       String Comment7 = "GROUP  Type - String (categories are { \"CONTROL\"  \"EXPERMTL\" } )\n";

       Comment += Comment7;

       String Comment8 = "TIME  Type - String (categories are { \"AFTER_1\"  \"AFTER_2\"  \"BEFORE\" } )\n";

       Comment += Comment8;

       String Comment9 = "PAID  Type - String (categories are { \"NOT_PAID\"  \"PAID\" } )\n";

       Comment += Comment9;

       Comment += Comment1;

       System.out.println(Comment);

       System.exit(1);

     }

     __Exp_in_memory_performance_experi_MLP_11_6_2( ContInputs, CatInputs );

   }



}

