import java.io.*;

import java.util.*;





public class Predict

{

   public static void __Sheet1_in_Weather_re_MLP_31_5_4( double[] ContInputs, String[] CatInputs )

   {

     //"Input Variable" comment is added besides Input(Response) variables.



     int Cont_idx=0;

     int Cat_idx=0;

     double _Temperature__ = ContInputs[Cont_idx++]; //Input Variable

     String _Location__ = CatInputs[Cat_idx++]; //Input Variable

     String __statist_PredCat="";

    String [] __statist_DCats = new String[4];

    __statist_DCats[0]= "Cloudy";

    __statist_DCats[1]= "Rain";

    __statist_DCats[2]= "Sunny";

    __statist_DCats[3]= "T-storm";



    double __statist_ConfLevel=3.0E-300;



    double[] __statist_max_input = new double[1];

    __statist_max_input[0]= 1.03000000000000e+002;



    double[] __statist_min_input = new double[1];

    __statist_min_input[0]= 7.20000000000000e+001;





    double[][] __statist_i_h_wts = new double[5][31];



    __statist_i_h_wts[0][0]=3.79995796646256e+001;

    __statist_i_h_wts[0][1]=2.53210052773237e-002;

    __statist_i_h_wts[0][2]=1.05254154377779e+001;

    __statist_i_h_wts[0][3]=-1.00107218817363e+001;

    __statist_i_h_wts[0][4]=6.47944474546303e-003;

    __statist_i_h_wts[0][5]=-6.38639740984530e-003;

    __statist_i_h_wts[0][6]=1.48029618697970e+001;

    __statist_i_h_wts[0][7]=1.06188393364830e+001;

    __statist_i_h_wts[0][8]=1.26004589525446e-002;

    __statist_i_h_wts[0][9]=-1.83354735390630e+001;

    __statist_i_h_wts[0][10]=1.01766596896991e+001;

    __statist_i_h_wts[0][11]=-1.92779650102243e+001;

    __statist_i_h_wts[0][12]=-1.01048108540689e+001;

    __statist_i_h_wts[0][13]=1.02304107328093e+001;

    __statist_i_h_wts[0][14]=1.05904620346364e+001;

    __statist_i_h_wts[0][15]=1.01498878195409e+001;

    __statist_i_h_wts[0][16]=-1.87085771564704e-002;

    __statist_i_h_wts[0][17]=1.16914394125608e-002;

    __statist_i_h_wts[0][18]=9.89404820049211e-003;

    __statist_i_h_wts[0][19]=-1.01869946172224e+001;

    __statist_i_h_wts[0][20]=-1.36590205836370e+001;

    __statist_i_h_wts[0][21]=-9.95121797951759e+000;

    __statist_i_h_wts[0][22]=1.01373641187092e+001;

    __statist_i_h_wts[0][23]=-6.36847254719639e+000;

    __statist_i_h_wts[0][24]=1.04587258159149e+001;

    __statist_i_h_wts[0][25]=-1.00875131182784e+001;

    __statist_i_h_wts[0][26]=-4.97189683535344e+000;

    __statist_i_h_wts[0][27]=-1.06588167384868e+001;

    __statist_i_h_wts[0][28]=-2.99730404289516e-002;

    __statist_i_h_wts[0][29]=1.05731584606051e+001;

    __statist_i_h_wts[0][30]=1.02588369475374e+001;



    __statist_i_h_wts[1][0]=-9.03212101848402e+000;

    __statist_i_h_wts[1][1]=1.14705854643839e-002;

    __statist_i_h_wts[1][2]=-1.23643513146273e+000;

    __statist_i_h_wts[1][3]=1.01287629510662e+001;

    __statist_i_h_wts[1][4]=-3.16841127354265e-002;

    __statist_i_h_wts[1][5]=-1.20700638856917e-002;

    __statist_i_h_wts[1][6]=-1.84554725501110e+000;

    __statist_i_h_wts[1][7]=-1.26083316146263e+000;

    __statist_i_h_wts[1][8]=5.83136260214256e-002;

    __statist_i_h_wts[1][9]=1.37799396748628e+001;

    __statist_i_h_wts[1][10]=-1.25528437821337e+000;

    __statist_i_h_wts[1][11]=1.32813021526219e+001;

    __statist_i_h_wts[1][12]=1.05222798108530e+001;

    __statist_i_h_wts[1][13]=-1.26681835617030e+000;

    __statist_i_h_wts[1][14]=-1.27333599226736e+000;

    __statist_i_h_wts[1][15]=-1.27078384823849e+000;

    __statist_i_h_wts[1][16]=7.62663922061511e-004;

    __statist_i_h_wts[1][17]=2.68747074330427e-003;

    __statist_i_h_wts[1][18]=2.77866756611204e-002;

    __statist_i_h_wts[1][19]=-1.76867135976093e+001;

    __statist_i_h_wts[1][20]=-1.91349324361920e+001;

    __statist_i_h_wts[1][21]=9.73389149580263e+000;

    __statist_i_h_wts[1][22]=-1.30599934094438e+000;

    __statist_i_h_wts[1][23]=-1.58276485116699e+001;

    __statist_i_h_wts[1][24]=-1.25336542377262e+000;

    __statist_i_h_wts[1][25]=1.15505061347645e+001;

    __statist_i_h_wts[1][26]=-1.38197631911595e+001;

    __statist_i_h_wts[1][27]=7.88743897412281e+000;

    __statist_i_h_wts[1][28]=7.26812456159819e-003;

    __statist_i_h_wts[1][29]=-1.23769641096804e+000;

    __statist_i_h_wts[1][30]=-1.28472970969272e+000;



    __statist_i_h_wts[2][0]=7.39363267505677e+000;

    __statist_i_h_wts[2][1]=4.83942285054489e-002;

    __statist_i_h_wts[2][2]=1.22168343344859e-001;

    __statist_i_h_wts[2][3]=-4.84148407385583e+000;

    __statist_i_h_wts[2][4]=-2.21331762005183e-002;

    __statist_i_h_wts[2][5]=-2.59430608753720e-003;

    __statist_i_h_wts[2][6]=-3.45656209219622e-001;

    __statist_i_h_wts[2][7]=1.17997317727998e-001;

    __statist_i_h_wts[2][8]=6.02974921060894e-002;

    __statist_i_h_wts[2][9]=-4.91928343322038e+000;

    __statist_i_h_wts[2][10]=1.01823677940248e-001;

    __statist_i_h_wts[2][11]=-4.69186342210177e+000;

    __statist_i_h_wts[2][12]=-4.91640005528391e+000;

    __statist_i_h_wts[2][13]=1.15757781131757e-001;

    __statist_i_h_wts[2][14]=1.26910146484908e-001;

    __statist_i_h_wts[2][15]=7.02614562072588e-002;

    __statist_i_h_wts[2][16]=-2.26127262880953e-002;

    __statist_i_h_wts[2][17]=-3.02991013533742e-002;

    __statist_i_h_wts[2][18]=5.89113178725598e-003;

    __statist_i_h_wts[2][19]=8.57122223716449e+000;

    __statist_i_h_wts[2][20]=1.45104710407029e+001;

    __statist_i_h_wts[2][21]=-4.75312162536381e+000;

    __statist_i_h_wts[2][22]=1.00855745190293e-001;

    __statist_i_h_wts[2][23]=7.36922765796700e+000;

    __statist_i_h_wts[2][24]=1.19176146016910e-001;

    __statist_i_h_wts[2][25]=-5.15958898452689e+000;

    __statist_i_h_wts[2][26]=6.75086136607745e+000;

    __statist_i_h_wts[2][27]=-4.34894328242916e+000;

    __statist_i_h_wts[2][28]=1.39504528334013e-002;

    __statist_i_h_wts[2][29]=1.32974525489279e-001;

    __statist_i_h_wts[2][30]=1.17938260323102e-001;



    __statist_i_h_wts[3][0]=1.27612428603750e+001;

    __statist_i_h_wts[3][1]=-9.28958486898508e-003;

    __statist_i_h_wts[3][2]=1.12328717706351e+000;

    __statist_i_h_wts[3][3]=-5.08934415264482e+000;

    __statist_i_h_wts[3][4]=-9.64179107176173e-003;

    __statist_i_h_wts[3][5]=1.98739527154743e-003;

    __statist_i_h_wts[3][6]=1.19214857322482e+000;

    __statist_i_h_wts[3][7]=1.10357647209424e+000;

    __statist_i_h_wts[3][8]=3.38470691139282e-002;

    __statist_i_h_wts[3][9]=-5.68734818489459e+000;

    __statist_i_h_wts[3][10]=1.08453506958337e+000;

    __statist_i_h_wts[3][11]=-5.68620342534903e+000;

    __statist_i_h_wts[3][12]=-5.13332696801806e+000;

    __statist_i_h_wts[3][13]=1.10851917442994e+000;

    __statist_i_h_wts[3][14]=1.06579180749078e+000;

    __statist_i_h_wts[3][15]=1.12912074525835e+000;

    __statist_i_h_wts[3][16]=4.59559319200956e-003;

    __statist_i_h_wts[3][17]=-1.67714979332756e-002;

    __statist_i_h_wts[3][18]=-1.70148316399580e-002;

    __statist_i_h_wts[3][19]=3.36617892438464e+000;

    __statist_i_h_wts[3][20]=1.46110056414540e+001;

    __statist_i_h_wts[3][21]=-5.05789027251093e+000;

    __statist_i_h_wts[3][22]=1.10271603943882e+000;

    __statist_i_h_wts[3][23]=3.26839046359650e+000;

    __statist_i_h_wts[3][24]=1.11598416301315e+000;

    __statist_i_h_wts[3][25]=-5.22399695528839e+000;

    __statist_i_h_wts[3][26]=2.92350970834139e+000;

    __statist_i_h_wts[3][27]=-4.89478342169286e+000;

    __statist_i_h_wts[3][28]=1.19395521560535e-002;

    __statist_i_h_wts[3][29]=1.11997085078144e+000;

    __statist_i_h_wts[3][30]=1.09087417069732e+000;



    __statist_i_h_wts[4][0]=4.81519627753707e+000;

    __statist_i_h_wts[4][1]=2.08258913420575e-002;

    __statist_i_h_wts[4][2]=-3.11210457876404e+000;

    __statist_i_h_wts[4][3]=2.40297733155733e+000;

    __statist_i_h_wts[4][4]=6.52909661571473e-003;

    __statist_i_h_wts[4][5]=3.83777104968654e-003;

    __statist_i_h_wts[4][6]=-4.35661352943435e+000;

    __statist_i_h_wts[4][7]=-3.12620607856846e+000;

    __statist_i_h_wts[4][8]=1.47732635705429e-002;

    __statist_i_h_wts[4][9]=5.24179185144300e+000;

    __statist_i_h_wts[4][10]=-3.11252363777735e+000;

    __statist_i_h_wts[4][11]=5.42828263730102e+000;

    __statist_i_h_wts[4][12]=2.57253250994015e+000;

    __statist_i_h_wts[4][13]=-3.14576185347621e+000;

    __statist_i_h_wts[4][14]=-3.14186189744036e+000;

    __statist_i_h_wts[4][15]=-3.12531341642694e+000;

    __statist_i_h_wts[4][16]=-1.18669051327987e-002;

    __statist_i_h_wts[4][17]=-3.20656605290875e-003;

    __statist_i_h_wts[4][18]=9.78442561194686e-003;

    __statist_i_h_wts[4][19]=-7.42486822875365e+000;

    __statist_i_h_wts[4][20]=2.50484324515577e+001;

    __statist_i_h_wts[4][21]=2.31813713328979e+000;

    __statist_i_h_wts[4][22]=-3.12881300614991e+000;

    __statist_i_h_wts[4][23]=-5.89153925831122e+000;

    __statist_i_h_wts[4][24]=-3.14820315108043e+000;

    __statist_i_h_wts[4][25]=2.79015935356748e+000;

    __statist_i_h_wts[4][26]=-4.68508658157901e+000;

    __statist_i_h_wts[4][27]=1.85357257134434e+000;

    __statist_i_h_wts[4][28]=2.30443100535527e-002;

    __statist_i_h_wts[4][29]=-3.13016556659359e+000;

    __statist_i_h_wts[4][30]=-3.12853854619054e+000;



    double[][] __statist_h_o_wts = new double[4][5];



    __statist_h_o_wts[0][0]=-3.35337670860623e+001;

    __statist_h_o_wts[0][1]=3.11328485815549e+001;

    __statist_h_o_wts[0][2]=-2.13369945226887e+001;

    __statist_h_o_wts[0][3]=-1.71150548069568e+001;

    __statist_h_o_wts[0][4]=4.45586580598829e+000;



    __statist_h_o_wts[1][0]=-3.89323173770110e+001;

    __statist_h_o_wts[1][1]=-1.56690082907762e+001;

    __statist_h_o_wts[1][2]=3.88087435942744e+000;

    __statist_h_o_wts[1][3]=-1.02082950352144e+001;

    __statist_h_o_wts[1][4]=-7.88565934602155e+000;



    __statist_h_o_wts[2][0]=5.71743238269170e+001;

    __statist_h_o_wts[2][1]=-1.56119681232609e+000;

    __statist_h_o_wts[2][2]=-1.76824994305843e+001;

    __statist_h_o_wts[2][3]=-1.23208311177585e+001;

    __statist_h_o_wts[2][4]=-3.40440452070289e+001;



    __statist_h_o_wts[3][0]=1.52247321525605e+001;

    __statist_h_o_wts[3][1]=-1.38297895406960e+001;

    __statist_h_o_wts[3][2]=3.51704887925072e+001;

    __statist_h_o_wts[3][3]=3.95675866144122e+001;

    __statist_h_o_wts[3][4]=3.73659789641511e+001;



    double[] __statist_hidden_bias = new double[5];

    __statist_hidden_bias[0]=-5.13355224086068e+000;

    __statist_hidden_bias[1]=-4.14791837930342e+000;

    __statist_hidden_bias[2]=4.41754263571503e+000;

    __statist_hidden_bias[3]=-2.88419866328359e-001;

    __statist_hidden_bias[4]=-5.87370026966630e+000;



    double[] __statist_output_bias = new double[4];

    __statist_output_bias[0]=3.27522231620181e+001;

    __statist_output_bias[1]=1.85553115914616e+001;

    __statist_output_bias[2]=-7.75354834123645e+000;

    __statist_output_bias[3]=-4.37936979597282e+001;



    double[] __statist_inputs = new double[31];



    double[] __statist_hidden = new double[5];



    double[] __statist_outputs = new double[4];

    __statist_outputs[0] = -1.0e+307;

    __statist_outputs[1] = -1.0e+307;

    __statist_outputs[2] = -1.0e+307;

    __statist_outputs[3] = -1.0e+307;



    __statist_inputs[0]=_Temperature__;



    if( _Location__.equals("Albuquerque"))

    {

     __statist_inputs[1]=1;

    }

    else

    {

     __statist_inputs[1]=0;

    }



    if( _Location__.equals("Atlanta"))

    {

     __statist_inputs[2]=1;

    }

    else

    {

     __statist_inputs[2]=0;

    }



    if( _Location__.equals("Baltimore"))

    {

     __statist_inputs[3]=1;

    }

    else

    {

     __statist_inputs[3]=0;

    }



    if( _Location__.equals("Birmingham"))

    {

     __statist_inputs[4]=1;

    }

    else

    {

     __statist_inputs[4]=0;

    }



    if( _Location__.equals("Boston"))

    {

     __statist_inputs[5]=1;

    }

    else

    {

     __statist_inputs[5]=0;

    }



    if( _Location__.equals("Chicago"))

    {

     __statist_inputs[6]=1;

    }

    else

    {

     __statist_inputs[6]=0;

    }



    if( _Location__.equals("Cincinnati"))

    {

     __statist_inputs[7]=1;

    }

    else

    {

     __statist_inputs[7]=0;

    }



    if( _Location__.equals("Cleveland"))

    {

     __statist_inputs[8]=1;

    }

    else

    {

     __statist_inputs[8]=0;

    }



    if( _Location__.equals("Columbus"))

    {

     __statist_inputs[9]=1;

    }

    else

    {

     __statist_inputs[9]=0;

    }



    if( _Location__.equals("Dallas"))

    {

     __statist_inputs[10]=1;

    }

    else

    {

     __statist_inputs[10]=0;

    }



    if( _Location__.equals("Denver"))

    {

     __statist_inputs[11]=1;

    }

    else

    {

     __statist_inputs[11]=0;

    }



    if( _Location__.equals("Detroit"))

    {

     __statist_inputs[12]=1;

    }

    else

    {

     __statist_inputs[12]=0;

    }



    if( _Location__.equals("Houston"))

    {

     __statist_inputs[13]=1;

    }

    else

    {

     __statist_inputs[13]=0;

    }



    if( _Location__.equals("Kansas City"))

    {

     __statist_inputs[14]=1;

    }

    else

    {

     __statist_inputs[14]=0;

    }



    if( _Location__.equals("Las Vegas"))

    {

     __statist_inputs[15]=1;

    }

    else

    {

     __statist_inputs[15]=0;

    }



    if( _Location__.equals("Los Angeles"))

    {

     __statist_inputs[16]=1;

    }

    else

    {

     __statist_inputs[16]=0;

    }



    if( _Location__.equals("Memphis"))

    {

     __statist_inputs[17]=1;

    }

    else

    {

     __statist_inputs[17]=0;

    }



    if( _Location__.equals("Miami"))

    {

     __statist_inputs[18]=1;

    }

    else

    {

     __statist_inputs[18]=0;

    }



    if( _Location__.equals("Milwaukee"))

    {

     __statist_inputs[19]=1;

    }

    else

    {

     __statist_inputs[19]=0;

    }



    if( _Location__.equals("New Orleans"))

    {

     __statist_inputs[20]=1;

    }

    else

    {

     __statist_inputs[20]=0;

    }



    if( _Location__.equals("New York"))

    {

     __statist_inputs[21]=1;

    }

    else

    {

     __statist_inputs[21]=0;

    }



    if( _Location__.equals("Oklahoma City"))

    {

     __statist_inputs[22]=1;

    }

    else

    {

     __statist_inputs[22]=0;

    }



    if( _Location__.equals("Philadelphia"))

    {

     __statist_inputs[23]=1;

    }

    else

    {

     __statist_inputs[23]=0;

    }



    if( _Location__.equals("Phoenix"))

    {

     __statist_inputs[24]=1;

    }

    else

    {

     __statist_inputs[24]=0;

    }



    if( _Location__.equals("Pittsburgh"))

    {

     __statist_inputs[25]=1;

    }

    else

    {

     __statist_inputs[25]=0;

    }



    if( _Location__.equals("Portland, OR"))

    {

     __statist_inputs[26]=1;

    }

    else

    {

     __statist_inputs[26]=0;

    }



    if( _Location__.equals("San Francisco"))

    {

     __statist_inputs[27]=1;

    }

    else

    {

     __statist_inputs[27]=0;

    }



    if( _Location__.equals("Seattle"))

    {

     __statist_inputs[28]=1;

    }

    else

    {

     __statist_inputs[28]=0;

    }



    if( _Location__.equals("St. Louis"))

    {

     __statist_inputs[29]=1;

    }

    else

    {

     __statist_inputs[29]=0;

    }



    if( _Location__.equals("Washington, D.C."))

    {

     __statist_inputs[30]=1;

    }

    else

    {

     __statist_inputs[30]=0;

    }



    double __statist_delta=0;

    double __statist_maximum=1;

    double __statist_minimum=0;

    int __statist_ncont_inputs=1;



    /*scale continuous inputs*/

    for(int __statist_i=0;__statist_i < __statist_ncont_inputs;__statist_i++)

    {

     __statist_delta = (__statist_maximum-__statist_minimum)/(__statist_max_input[__statist_i]-__statist_min_input[__statist_i]);

     __statist_inputs[__statist_i] = __statist_minimum - __statist_delta*__statist_min_input[__statist_i]+ __statist_delta*__statist_inputs[__statist_i];

    }



    int __statist_ninputs=31;

    int __statist_nhidden=5;



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

        __statist_hidden[__statist_row] = -1.0;

       }

       else

       {

        __statist_hidden[__statist_row] = Math.tanh(__statist_hidden[__statist_row]);

       }

      }

    }



    int __statist_noutputs=4;



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

     double[] ContInputs = new double[1];

     int contID = 0;

     String[] CatInputs = new String[1];

     int catID = 0;



     if (args.length >= 2)

     {

       ContInputs[contID++] =  Double.parseDouble(args[argID++]);

       CatInputs[catID++] = args[argID++];

     }

     else

     {

       String Comment = "";

       String Comment1 = "**************************************************************************\n";

       Comment += Comment1;

       String Comment2 = "Please enter at least 2 command line parameters in the following order for \nthe program to Predict.\n";

       Comment += Comment2;

       Comment += Comment1;

       String Comment3 = "Temperature  Type - double (or) integer\n";

       Comment += Comment3;

       String Comment4 = "Location  Type - String (categories are { \"Albuquerque\"  \"Atlanta\"  \"Baltimore\"  \"Birmingham\"  \"Boston\"  \"Chicago\"  \"Cincinnati\"  \"Cleveland\"  \"Columbus\"  \"Dallas\"  \"Denver\"  \"Detroit\"  \"Houston\"  \"Kansas City\"  \"Las Vegas\"  \"Los Angeles\"  \"Memphis\"  \"Miami\"  \"Milwaukee\"  \"New Orleans\"  \"New York\"  \"Oklahoma City\"  \"Philadelphia\"  \"Phoenix\"  \"Pittsburgh\"  \"Portland, OR\"  \"San Francisco\"  \"Seattle\"  \"St. Louis\"  \"Washington, D.C.\" } )\n";

       Comment += Comment4;

       Comment += Comment1;

       System.out.println(Comment);

       System.exit(1);

     }

     __Sheet1_in_Weather_re_MLP_31_5_4( ContInputs, CatInputs );

   }



}

