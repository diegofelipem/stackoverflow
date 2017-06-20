package swing.examples;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class DesenharChaveDialogTest extends JDialog {

    String[] param = {
        "Total das Horas Trabalhadas",
        "Art. 58 - Acomodação",
        "Art. 66 - 11 horas entrejornadas",
        "Art. 67 - 35 horas no final de semana",
        "Art. 71 - Intrajornada tempo Mínimo/Máximo",
        "Art. 72 - Datilografia 10m a cada 1h30m",
        "Art. 253 - Frio 20m a cada 1h40m",
        "NR-36",
        "Art. 384 - Mulheres 15 minutos na prorrogação",
        "Compensação (Jornada Digitada)",
        "Adicionar Horário no Início/Fim da Jornada",
        "Súmula 85 - Horas Dest. a Comp. (8h/48m)",
        "Adicional Noturno",
        "Horas Extras"};

    JComboBox cbPar = new JComboBox(param);

    JFormattedTextField tfPerIn, tfPerSai;
    MaskFormatter mfPerIn, mfPerSai;

    JButton btSend = new JButton("Confirmar");
    JButton btCanc = new JButton("Cancelar");

    Container cp;

    FlowLayout flSS = new FlowLayout(FlowLayout.TRAILING);
    FlowLayout flNL2 = new FlowLayout(FlowLayout.TRAILING);

    JPanel pnN = new JPanel(new GridLayout(2, 1));
    JPanel pnNL1 = new JPanel(new GridLayout(2, 1));
    JPanel pnNL1L1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnNL1L2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnNL2 = new JPanel(new GridLayout(2, 1));
    JPanel pnNL2L1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnNL2L2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnNL2L2c = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnS = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pnSS = new JPanel(flSS);
    JPanel pnC = new JPanel();

    //Total das Horas
    JPanel pnGer = new JPanel();

    //Art 58
    JPanel pn58 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pn58Aux = new JPanel(new GridLayout(3, 1));
    JPanel pn58L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn58L2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn58L3 = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JFormattedTextField tf58Tot;
    MaskFormatter mf58Tot;

    JRadioButton rb58Cond = new JRadioButton("Condicional / Abater o tempo de acomodação nas Horas Extras");
    JRadioButton rb58Fix = new JRadioButton("Fixa / Não Abate o tempo de acomodação nas Horas Extras");

    ButtonGroup bg58Rb = new ButtonGroup();

    //art 66
    JPanel pn66 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pn66Aux = new JPanel(new GridLayout(8, 1));

    JCheckBox ch66Seg = new JCheckBox("Segunda                                                       ");
    JCheckBox ch66Ter = new JCheckBox("Terça");
    JCheckBox ch66Qua = new JCheckBox("Quarta");
    JCheckBox ch66Qui = new JCheckBox("Quinta");
    JCheckBox ch66Sex = new JCheckBox("Sexta");
    JCheckBox ch66Sab = new JCheckBox("Sábado");
    JCheckBox ch66Dom = new JCheckBox("Domingo");
    JCheckBox ch66Fer = new JCheckBox("Feriado");

    //art 67
    JPanel pn67 = new JPanel();

    //art 71
    JPanel pn71 = new JPanel(new BorderLayout());
    JPanel pn71C1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn71C1Aux = new JPanel(new GridLayout(10, 1));
    JPanel pn71C1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L9 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C1L10 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn71C2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pn71C2Aux = new JPanel(new GridLayout(8, 1));

    JFormattedTextField tf71APartir, tf71Max, tf71Apurar1, tf71Apurar2;
    JTextField tf71Exc = new JTextField(2);
    JTextField tf71Semp = new JTextField(2);
    MaskFormatter mf71APartir, mf71Max, mf71Apurar1, mf71Apurar2;

    JCheckBox ch71Min = new JCheckBox("Tempo Mínimo");
    JCheckBox ch71Max = new JCheckBox("Tempo Máximo");
    JCheckBox ch71IntMin = new JCheckBox("Intervalo a partir do qual não se apura o Art. 71");
    JCheckBox ch71IntMax = new JCheckBox("Intervalo máximo a partir do qual se apura o Art. 71");
    JCheckBox ch71Exc = new JCheckBox("Exceto");
    JCheckBox ch71Semp = new JCheckBox("Sempre");
    JCheckBox ch71Apu = new JCheckBox("Apurar Diurno e Noturno Separadamente");
    JCheckBox ch71Dsr = new JCheckBox("Apurar Dias de D.S.R. Separadamente");

    JRadioButton rb71Dif = new JRadioButton("Apurar apenas a diferença - ou");
    JRadioButton rb71Fix = new JRadioButton("Apurar tempo fixo de");
    JRadioButton rb71Aux = new JRadioButton("");

    ButtonGroup bg71 = new ButtonGroup();

    JCheckBox ch71Seg = new JCheckBox("Segunda                                                       ");
    JCheckBox ch71Ter = new JCheckBox("Terça");
    JCheckBox ch71Qua = new JCheckBox("Quarta");
    JCheckBox ch71Qui = new JCheckBox("Quinta");
    JCheckBox ch71Sex = new JCheckBox("Sexta");
    JCheckBox ch71Sab = new JCheckBox("Sábado");
    JCheckBox ch71Dom = new JCheckBox("Domingo");
    JCheckBox ch71Fer = new JCheckBox("Feriado");

    //art72
    JPanel pn72 = new JPanel(new BorderLayout());
    JPanel pn72C1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn72C1Aux = new JPanel(new GridLayout(17, 1));
    JPanel pn72C1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L9 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L10 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L11 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C1L12 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn72C2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn72C2Aux = new JPanel(new GridLayout(8, 1));

    JCheckBox ch72Desc = new JCheckBox("Desconsiderar Jornada Acrescida no Sistema");
    JCheckBox ch72DiuNotSep = new JCheckBox("Apurar Diurno e Noturno Separadamente");
    JCheckBox ch72Dsr = new JCheckBox("Apurar dias de D.S.R. Separadamente");
    JCheckBox ch72AbFolg = new JCheckBox("Abater Folgas Concedidas até o Limite De:");
    JCheckBox ch72LimCalcA = new JCheckBox("Limitar os Cálculos a:");
    JCheckBox ch72LimCalcAte = new JCheckBox("Limitar os Cálculos até a:");
    JCheckBox ch72CalcAte = new JCheckBox("Calcular somente até as:");
    JCheckBox ch72CalcApart = new JCheckBox("Calcular somente a partir das:");
    JCheckBox ch72IntFirst = new JCheckBox("Intervalo fixo na primeira/única Semana:");
    JCheckBox ch72IntSeg = new JCheckBox("Intervalo fixo na segunda semana:");
    JCheckBox ch72DiasUteisCorridos = new JCheckBox("Dias Úteis / Dias Corridos");

    JCheckBox ch72Dom = new JCheckBox("Domingo");
    JCheckBox ch72Seg = new JCheckBox("Segunda                                              ");
    JCheckBox ch72Ter = new JCheckBox("Terça");
    JCheckBox ch72Qua = new JCheckBox("Quarta");
    JCheckBox ch72Qui = new JCheckBox("Quinta");
    JCheckBox ch72Sex = new JCheckBox("Sexta");
    JCheckBox ch72Sab = new JCheckBox("Sábado");
    JCheckBox ch72Fer = new JCheckBox("Feriado");

    JTextField tf72CalcA = new JTextField(4);

    JFormattedTextField tf72Int,
            tf72Acad,
            tf72LimDe,
            tf72LimCalcAte,
            tf72CalcAte,
            tf72CalcSo,
            tf72CalcApart,
            tf72IntFixFirst,
            tf72IntFixSeg;
    MaskFormatter mf72Int,
            mf72Acad,
            mf72LimDe,
            mf72LimCalcAte,
            mf72CalcAte,
            mf72CalcSo,
            mf72CalcApart,
            mf72IntFixFirst,
            mf72IntFixSeg;

    //art253
    JPanel pn253 = new JPanel(new BorderLayout());
    JPanel pn253C1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn253C1Aux = new JPanel(new GridLayout(17, 1));
    JPanel pn253C1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L9 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L10 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L11 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C1L12 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn253C2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn253C2Aux = new JPanel(new GridLayout(8, 1));

    JCheckBox ch253Desc = new JCheckBox("Desconsiderar Jornada Acrescida no Sistema");
    JCheckBox ch253DiuNotSep = new JCheckBox("Apurar Diurno e Noturno Separadamente");
    JCheckBox ch253Dsr = new JCheckBox("Apurar dias de D.S.R. Separadamente");
    JCheckBox ch253AbFolg = new JCheckBox("Abater Folgas Concedidas até o Limite De:");
    JCheckBox ch253LimCalcA = new JCheckBox("Limitar os Cálculos a:");
    JCheckBox ch253LimCalcAte = new JCheckBox("Limitar os Cálculos até a:");
    JCheckBox ch253CalcAte = new JCheckBox("Calcular somente até as:");
    JCheckBox ch253CalcApart = new JCheckBox("Calcular somente a partir das:");
    JCheckBox ch253IntFirst = new JCheckBox("Intervalo fixo na primeira/única Semana:");
    JCheckBox ch253IntSeg = new JCheckBox("Intervalo fixo na segunda semana:");
    JCheckBox ch253DiasUteisCorridos = new JCheckBox("Dias Úteis / Dias Corridos");

    JCheckBox ch253Dom = new JCheckBox("Domingo");
    JCheckBox ch253Seg = new JCheckBox("Segunda                                              ");
    JCheckBox ch253Ter = new JCheckBox("Terça");
    JCheckBox ch253Qua = new JCheckBox("Quarta");
    JCheckBox ch253Qui = new JCheckBox("Quinta");
    JCheckBox ch253Sex = new JCheckBox("Sexta");
    JCheckBox ch253Sab = new JCheckBox("Sábado");
    JCheckBox ch253Fer = new JCheckBox("Feriado");

    JTextField tf253CalcA = new JTextField(4);

    JFormattedTextField tf253Int,
            tf253Acad,
            tf253LimDe,
            tf253LimCalcAte,
            tf253CalcAte,
            tf253CalcSo,
            tf253CalcApart,
            tf253IntFixFirst,
            tf253IntFixSeg;
    MaskFormatter mf253Int,
            mf253Acad,
            mf253LimDe,
            mf253LimCalcAte,
            mf253CalcAte,
            mf253CalcSo,
            mf253CalcApart,
            mf253IntFixFirst,
            mf253IntFixSeg;

    //nr36
    JPanel pn36 = new JPanel(new BorderLayout());//primeira semana
    JPanel pn36C1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn36C1Aux = new JPanel(new GridLayout(17, 1));
    JPanel pn36C1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L9 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L10 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L11 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L12 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L13 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L14 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L15 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L16 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C1L17 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn36C2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn36C2Aux = new JPanel(new GridLayout(8, 1));

    JCheckBox ch366h = new JCheckBox("Até 6h20m");
    JCheckBox ch367h = new JCheckBox("Até 7h40m");
    JCheckBox ch369h10 = new JCheckBox("Até 9h10m");
    JCheckBox ch369h50 = new JCheckBox("Até 9h58m");
    JCheckBox ch36M9h50 = new JCheckBox("Até 9h58m");
    JCheckBox ch36Desc = new JCheckBox("Desconsiderar Jornada Acrescida no Sistema");
    JCheckBox ch36DiuNotSep = new JCheckBox("Apurar Diurno e Noturno Separadamente");
    JCheckBox ch36Dsr = new JCheckBox("Apurar dias de D.S.R. Separadamente");
    JCheckBox ch36AbFolg = new JCheckBox("Abater Folgas Concedidas até o Limite De:");
    JCheckBox ch36LimCalcA = new JCheckBox("Limitar os Cálculos a:");
    JCheckBox ch36LimCalcAte = new JCheckBox("Limitar os Cálculos até a:");
    JCheckBox ch36CalcAte = new JCheckBox("Calcular somente até as:");
    JCheckBox ch36CalcApart = new JCheckBox("Calcular somente a partir das:");
    JCheckBox ch36IntFirst = new JCheckBox("Intervalo fixo na primeira/única Semana:");
    JCheckBox ch36IntSeg = new JCheckBox("Intervalo fixo na segunda semana:");
    JCheckBox ch36DiasUteisCorridos = new JCheckBox("Dias Úteis / Dias Corridos");

    JCheckBox ch36Dom = new JCheckBox("Domingo");
    JCheckBox ch36Seg = new JCheckBox("Segunda                                              ");
    JCheckBox ch36Ter = new JCheckBox("Terça");
    JCheckBox ch36Qua = new JCheckBox("Quarta");
    JCheckBox ch36Qui = new JCheckBox("Quinta");
    JCheckBox ch36Sex = new JCheckBox("Sexta");
    JCheckBox ch36Sab = new JCheckBox("Sábado");
    JCheckBox ch36Fer = new JCheckBox("Feriado");

    JTextField tf36CalcA = new JTextField(4);

    JFormattedTextField tf36Int,
            tf36Acad,
            tf366h,
            tf367h,
            tf369h10,
            tf369h50,
            tf36LimDe,
            tf36LimCalcAte,
            tf36CalcAte,
            tf36CalcSo,
            tf36CalcApart,
            tf36IntFixFirst,
            tf36IntFixSeg;
    MaskFormatter mf36Int,
            mf36Acad,
            mf366h,
            mf367h,
            mf369h10,
            mf369h50,
            mf36LimDe,
            mf36LimCalcAte,
            mf36CalcAte,
            mf36CalcSo,
            mf36CalcApart,
            mf36IntFixFirst,
            mf36IntFixSeg;

    //art 384
    JPanel pn384 = new JPanel(new BorderLayout());
    JPanel pn384C1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn384C1Aux = new JPanel(new GridLayout(5, 1));
    JPanel pn384C1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn384C1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn384C1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn384C1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn384C1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pn384C2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pn384C2Aux = new JPanel(new GridLayout(8, 1));

    JFormattedTextField tf384Int,
            tf384Sup;
    MaskFormatter mf384Int,
            mf384Sup;

    JCheckBox ch384Desc = new JCheckBox("Desconsiderar Jornada Acrescida no Sistema");
    JCheckBox ch384DiuNot = new JCheckBox("Apurar Diurno e Noturno Separadamente");
    JCheckBox ch384Dsr = new JCheckBox("Apurar Dias de D.S.R. Separadamente");
    JCheckBox ch384Seg = new JCheckBox("Segunda                                                       ");
    JCheckBox ch384Ter = new JCheckBox("Terça");
    JCheckBox ch384Qua = new JCheckBox("Quarta");
    JCheckBox ch384Qui = new JCheckBox("Quinta");
    JCheckBox ch384Sex = new JCheckBox("Sexta");
    JCheckBox ch384Sab = new JCheckBox("Sábado");
    JCheckBox ch384Dom = new JCheckBox("Domingo");
    JCheckBox ch384Fer = new JCheckBox("Feriado");

    //compensação
    JPanel pnComp = new JPanel();

    //adcIn / adc Fin
    JPanel pnAdc = new JPanel(new BorderLayout());
    JPanel pnAdcC1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnAdcC1Aux = new JPanel(new GridLayout(8, 1));
    JPanel pnAdcC1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcC2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnAdcC2Aux = new JPanel(new GridLayout(8, 1));

    JTextField tfAdcDesc = new JTextField(30);
    JFormattedTextField tfAdcQntAntSe,
            tfAdcQntDpsSe;
    MaskFormatter mfAdcQntAntSe,
            mfAdcQntDpsSe;

    JTextField tfAdcQntAnt = new JTextField(5);
    JTextField tfAdcQntDps = new JTextField(5);

    JCheckBox chAdcAntSe = new JCheckBox("Se a jornada iniciar antes das:");
    JCheckBox chAdcDpsSe = new JCheckBox("Se a jornada terminar após as:");

    JCheckBox chAdcDiu = new JCheckBox("Apurar horas Diurno/Noturno Separadamente");
    JCheckBox chAdcDsr = new JCheckBox("Apurar Dias de D.S.R. Separadamente");
    JCheckBox chAdcExcDia = new JCheckBox("Apurar somente o Excedente Diário da Jornada");
    JCheckBox chAdcExcSem = new JCheckBox("Apurar somente o Excedente Semanal da Jornada");
    JCheckBox chAdcExcDiSe = new JCheckBox("Apurar somente o Excedente Diário/Semanal da Jornada");

    JCheckBox chAdcDom = new JCheckBox("Domingo");
    JCheckBox chAdcSeg = new JCheckBox("Segunda                                                       ");
    JCheckBox chAdcTer = new JCheckBox("Terça");
    JCheckBox chAdcQua = new JCheckBox("Quarta");
    JCheckBox chAdcQui = new JCheckBox("Quinta");
    JCheckBox chAdcSex = new JCheckBox("Sexta");
    JCheckBox chAdcSab = new JCheckBox("Sábado");
    JCheckBox chAdcFer = new JCheckBox("Feriado");

    //súmula 85
    JPanel pnSum = new JPanel(new BorderLayout());
    JPanel pnSumC1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnSumC1L = new JPanel(new GridLayout(4, 1));
    JPanel pnSumC1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnSumC1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnSumC1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnSumC1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));

    JPanel pnSumC2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnSumC2L = new JPanel(new GridLayout(8, 1));

    JPanel pnSumC3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnSumC3L = new JPanel(new GridLayout(8, 1));

    JPanel pnSumAux = new JPanel(new FlowLayout(FlowLayout.LEADING));

    JCheckBox chSumApu = new JCheckBox("Apurar horas Diurno / Noturno Separadamente");
    JCheckBox chSumCondSeg = new JCheckBox("Segunda                                 ");
    JCheckBox chSumCondTer = new JCheckBox("Terça");
    JCheckBox chSumCondQua = new JCheckBox("Quarta");
    JCheckBox chSumCondQui = new JCheckBox("Quinta");
    JCheckBox chSumCondSex = new JCheckBox("Sexta");
    JCheckBox chSumCondSab = new JCheckBox("Sábado");
    JCheckBox chSumCondDom = new JCheckBox("Domingo");
    JCheckBox chSumCondFer = new JCheckBox("Feriado");

    JCheckBox chSumApuSeg = new JCheckBox("Segunda                                  ");
    JCheckBox chSumApuTer = new JCheckBox("Terça");
    JCheckBox chSumApuQua = new JCheckBox("Quarta");
    JCheckBox chSumApuQui = new JCheckBox("Quinta");
    JCheckBox chSumApuSex = new JCheckBox("Sexta");
    JCheckBox chSumApuSab = new JCheckBox("Sábado");
    JCheckBox chSumApuDom = new JCheckBox("Domingo");
    JCheckBox chSumApuFer = new JCheckBox("Feriado");

    JTextField tfSumQnt = new JTextField(2);
    JFormattedTextField tfSumJorn, tfSumTemp;
    MaskFormatter mfSumJorn, mfSumTemp;

    //Adicional Noturno
    JPanel pnAdcNot = new JPanel(new BorderLayout());
    JPanel pnAdcNotC1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnAdcNotC1Aux = new JPanel(new GridLayout(5, 1));
    JPanel pnAdcNotC1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcNotC1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcNotC1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcNotC1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcNotC1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnAdcNotC2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pnAdcNotC2Aux = new JPanel(new GridLayout(8, 1));

    JCheckBox chAdcNotExt = new JCheckBox("Extender Jornada Noturna Até o Encerramento da Jornada");
    JCheckBox chAdcNotApu = new JCheckBox("Apura apenas a Hora Noturna da Jornada Extendida (após às 05h)");
    JCheckBox chAdcNotRed = new JCheckBox("Redução Hora Noturna(52:30 por hora)");
    JCheckBox chAdcNotNor = new JCheckBox("Calcular apenas jornada normal (Sem H.E.)");

    JCheckBox chAdcNotDom = new JCheckBox("Domingo");
    JCheckBox chAdcNotSeg = new JCheckBox("Segunda");
    JCheckBox chAdcNotTer = new JCheckBox("Terça");
    JCheckBox chAdcNotQua = new JCheckBox("Quarta");
    JCheckBox chAdcNotQui = new JCheckBox("Quinta");
    JCheckBox chAdcNotSex = new JCheckBox("Sexta");
    JCheckBox chAdcNotSab = new JCheckBox("Sábado");
    JCheckBox chAdcNotFer = new JCheckBox("Feriado");

    JFormattedTextField tfAdcNotHorDas, tfAdcNotHorAs;
    MaskFormatter mfAdcNotHorDas, mfAdcNotHorAs;

    //Horas extras
    JPanel pnHe = new JPanel(new BorderLayout());
    JPanel pnHeC1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pnHeC1Aux = new JPanel(new GridLayout(8, 2));
    JPanel pnHeC1L1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeC1L8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSem = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pnHeSemAux = new JPanel(new GridLayout(8, 1));
    JPanel pnHeSemSeg = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemTer = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemQua = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemQui = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemSex = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemSab = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemDom = new JPanel(new FlowLayout(FlowLayout.LEADING));
    JPanel pnHeSemFer = new JPanel(new FlowLayout(FlowLayout.LEADING));

    JCheckBox chHeSeg = new JCheckBox("Seg ");
    JCheckBox chHeTer = new JCheckBox("Ter  ");
    JCheckBox chHeQua = new JCheckBox("Qua ");
    JCheckBox chHeQui = new JCheckBox("Qui  ");
    JCheckBox chHeSex = new JCheckBox("Sex ");
    JCheckBox chHeSab = new JCheckBox("Sab ");
    JCheckBox chHeDom = new JCheckBox("Dom");
    JCheckBox chHeFer = new JCheckBox("Fer  ");

    JCheckBox chHeSegAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeTerAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeQuaAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeQuiAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeSexAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeSabAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeDomAp = new JCheckBox("Apura Agrupado");
    JCheckBox chHeFerAp = new JCheckBox("Apura Agrupado");

    JTextField tfHeSeg = new JTextField(4);
    JTextField tfHeTer = new JTextField(4);
    JTextField tfHeQua = new JTextField(4);
    JTextField tfHeQui = new JTextField(4);
    JTextField tfHeSex = new JTextField(4);
    JTextField tfHeSab = new JTextField(4);
    JTextField tfHeDom = new JTextField(4);
    JTextField tfHeFer = new JTextField(4);

    JCheckBox chHeDiario = new JCheckBox("Apura excedente Diário");
    JCheckBox chHeSemana = new JCheckBox("Apura excedente Semanal");
    JCheckBox chHeDsr = new JCheckBox("Apura excedente DSR (Domingos/Feriados)");
    JCheckBox chHeDiuNot = new JCheckBox("Apura Diurno/Noturno separadamente");
    JCheckBox chHeDiaSem = new JCheckBox("Apura excedente Diário/Semanal");
    JCheckBox chHeNotSep = new JCheckBox("Apura excedente das \"horas noturnas acrescidas\" separadamente");
    JCheckBox chHeEncerr = new JCheckBox("Apura excedente jornada Noturna até o encerramento do cartão");
    JCheckBox chHeDupTri = new JCheckBox("Horas extras duplas/triplas");

    JFormattedTextField tfHeFaixa1, tfHeFaixa2;
    MaskFormatter mfHeFaixa1, mfHeFaixa2;

    JTabbedPane tb1 = new JTabbedPane();

//    final StringTools stT = new StringTools();
//    public CalculoDeHE(Processo p) {
    public DesenharChaveDialogTest() {
        try {
            mfPerIn = new MaskFormatter("##/##/####");
            mfPerSai = new MaskFormatter("##/##/####");

            mf58Tot = new MaskFormatter("##:##");

            mfHeFaixa1 = new MaskFormatter("##:##");
            mfHeFaixa2 = new MaskFormatter("##:##");

            mf71APartir = new MaskFormatter("##:##");
            mf71Apurar1 = new MaskFormatter("##:##");
            mf71Apurar2 = new MaskFormatter("##:##");
            mf71Max = new MaskFormatter("##:##");

            mf384Int = new MaskFormatter("##:##");
            mf384Sup = new MaskFormatter("##:##");

            mfSumJorn = new MaskFormatter("##:##");
            mfSumTemp = new MaskFormatter("##:##");

            mfAdcNotHorAs = new MaskFormatter("##:##");
            mfAdcNotHorDas = new MaskFormatter("##:##");
//            mfAdcQntAnt = new MaskFormatter("##:##");
            mfAdcQntAntSe = new MaskFormatter("##:##");
//            mfAdcQntDps = new MaskFormatter("##:##");
            mfAdcQntDpsSe = new MaskFormatter("##:##");

            mf72Int = new MaskFormatter("##:##");
            mf72Acad = new MaskFormatter("##:##");
            mf72LimDe = new MaskFormatter("##:##");
            mf72LimCalcAte = new MaskFormatter("##:##");
            mf72CalcAte = new MaskFormatter("##:##");
            mf72CalcSo = new MaskFormatter("##:##");
            mf72CalcApart = new MaskFormatter("##:##");
            mf72IntFixFirst = new MaskFormatter("##:##");
            mf72IntFixSeg = new MaskFormatter("##:##");

            mf253Int = new MaskFormatter("##:##");
            mf253Acad = new MaskFormatter("##:##");
            mf253LimDe = new MaskFormatter("##:##");
            mf253LimCalcAte = new MaskFormatter("##:##");
            mf253CalcAte = new MaskFormatter("##:##");
            mf253CalcSo = new MaskFormatter("##:##");
            mf253CalcApart = new MaskFormatter("##:##");
            mf253IntFixFirst = new MaskFormatter("##:##");
            mf253IntFixSeg = new MaskFormatter("##:##");

            mf36Int = new MaskFormatter("##:##");
            mf36Acad = new MaskFormatter("##:##");
            mf366h = new MaskFormatter("##:##");
            mf367h = new MaskFormatter("##:##");
            mf369h10 = new MaskFormatter("##:##");
            mf369h50 = new MaskFormatter("##:##");
            mf36LimDe = new MaskFormatter("##:##");
            mf36LimCalcAte = new MaskFormatter("##:##");
            mf36CalcAte = new MaskFormatter("##:##");
            mf36CalcSo = new MaskFormatter("##:##");
            mf36CalcApart = new MaskFormatter("##:##");
            mf36IntFixFirst = new MaskFormatter("##:##");
            mf36IntFixSeg = new MaskFormatter("##:##");
        } catch (Exception E) {
            E.printStackTrace();
        }

        tf72Int = new JFormattedTextField(mf72Int);
        tf72Acad = new JFormattedTextField(mf72Acad);
        tf72LimDe = new JFormattedTextField(mf72LimDe);
        tf72LimCalcAte = new JFormattedTextField(mf72LimCalcAte);
        tf72CalcAte = new JFormattedTextField(mf72CalcAte);
        tf72CalcSo = new JFormattedTextField(mf72CalcSo);
        tf72CalcApart = new JFormattedTextField(mf72CalcApart);
        tf72IntFixFirst = new JFormattedTextField(mf72IntFixFirst);
        tf72IntFixSeg = new JFormattedTextField(mf72IntFixSeg);

        tf72Int.setColumns(3);
        tf72Acad.setColumns(3);
        tf72LimDe.setColumns(3);
        tf72LimCalcAte.setColumns(3);
        tf72CalcAte.setColumns(3);
        tf72CalcSo.setColumns(3);
        tf72CalcApart.setColumns(3);
        tf72IntFixSeg.setColumns(3);
        tf72IntFixFirst.setColumns(3);

        tf253Int = new JFormattedTextField(mf253Int);
        tf253Acad = new JFormattedTextField(mf253Acad);
        tf253LimDe = new JFormattedTextField(mf253LimDe);
        tf253LimCalcAte = new JFormattedTextField(mf253LimCalcAte);
        tf253CalcAte = new JFormattedTextField(mf253CalcAte);
        tf253CalcSo = new JFormattedTextField(mf253CalcSo);
        tf253CalcApart = new JFormattedTextField(mf253CalcApart);
        tf253IntFixFirst = new JFormattedTextField(mf253IntFixFirst);
        tf253IntFixSeg = new JFormattedTextField(mf253IntFixSeg);

        tf253Int.setColumns(3);
        tf253Acad.setColumns(3);
        tf253LimDe.setColumns(3);
        tf253LimCalcAte.setColumns(3);
        tf253CalcAte.setColumns(3);
        tf253CalcSo.setColumns(3);
        tf253CalcApart.setColumns(3);
        tf253IntFixSeg.setColumns(3);
        tf253IntFixFirst.setColumns(3);

        tf36Int = new JFormattedTextField(mf36Int);
        tf36Acad = new JFormattedTextField(mf36Acad);
        tf366h = new JFormattedTextField(mf366h);
        tf367h = new JFormattedTextField(mf367h);
        tf369h10 = new JFormattedTextField(mf369h10);
        tf369h50 = new JFormattedTextField(mf369h50);
        tf36LimDe = new JFormattedTextField(mf36LimDe);
        tf36LimCalcAte = new JFormattedTextField(mf36LimCalcAte);
        tf36CalcAte = new JFormattedTextField(mf36CalcAte);
        tf36CalcSo = new JFormattedTextField(mf36CalcSo);
        tf36CalcApart = new JFormattedTextField(mf36CalcApart);
        tf36IntFixFirst = new JFormattedTextField(mf36IntFixFirst);
        tf36IntFixSeg = new JFormattedTextField(mf36IntFixSeg);

        tf36Int.setColumns(3);
        tf36Acad.setColumns(3);
        tf366h.setColumns(3);
        tf367h.setColumns(3);
        tf369h10.setColumns(3);
        tf369h50.setColumns(3);
        tf36LimDe.setColumns(3);
        tf36LimCalcAte.setColumns(3);
        tf36CalcAte.setColumns(3);
        tf36CalcSo.setColumns(3);
        tf36CalcApart.setColumns(3);
        tf36IntFixSeg.setColumns(3);
        tf36IntFixFirst.setColumns(3);

//        tfAdcQntAnt = new JFormattedTextField(mfAdcQntAnt);
//        tfAdcQntDps = new JFormattedTextField(mfAdcQntDps);
        tfAdcQntAntSe = new JFormattedTextField(mfAdcQntAntSe);
        tfAdcQntDpsSe = new JFormattedTextField(mfAdcQntDpsSe);
//        tfAdcQntAnt.setColumns(3);
//        tfAdcQntDps.setColumns(3);
        tfAdcQntAntSe.setColumns(3);
        tfAdcQntDpsSe.setColumns(3);

        tfAdcNotHorAs = new JFormattedTextField(mfAdcNotHorAs);
        tfAdcNotHorAs.setColumns(3);
        tfAdcNotHorDas = new JFormattedTextField(mfAdcNotHorDas);
        tfAdcNotHorDas.setColumns(3);

        tfSumJorn = new JFormattedTextField(mfSumJorn);
        tfSumJorn.setColumns(3);
        tfSumTemp = new JFormattedTextField(mfSumTemp);
        tfSumTemp.setColumns(3);

        tf58Tot = new JFormattedTextField(mf58Tot);
        tf58Tot.setColumns(3);

        tf384Int = new JFormattedTextField(mf384Int);
        tf384Sup = new JFormattedTextField(mf384Sup);
        tf384Int.setColumns(3);
        tf384Sup.setColumns(3);

        tf71Apurar1 = new JFormattedTextField(mf71Apurar1);
        tf71Apurar2 = new JFormattedTextField(mf71Apurar2);
        tf71APartir = new JFormattedTextField(mf71APartir);
        tf71Max = new JFormattedTextField(mf71Max);
        tf71APartir.setColumns(3);
        tf71Apurar1.setColumns(3);
        tf71Apurar2.setColumns(3);
        tf71Max.setColumns(3);

        tfHeFaixa1 = new JFormattedTextField(mfHeFaixa1);
        tfHeFaixa2 = new JFormattedTextField(mfHeFaixa2);
        tfHeFaixa1.setColumns(3);
        tfHeFaixa2.setColumns(3);

        tfPerIn = new JFormattedTextField(mfPerIn);
        tfPerIn.setColumns(6);
        tfPerSai = new JFormattedTextField(mfPerSai);
        tfPerSai.setColumns(6);

        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Parâmetros para Cálculo das Horas Extras");
        setModal(true);
//        URL url = this.getClass().getResource("BergoD.gif");
//        Image img = Toolkit.getDefaultToolkit().getImage(url);
//        this.setIconImage(img);

        pnNL1L1.add(new JLabel("<html><br>Tipo de cálculo que será efetuado no Cartão Ponto</html>"));
        pnNL1L2.add(cbPar);
        cbPar.setMaximumRowCount(15);

        pnNL2L1.add(new JLabel("<html><br>Período do Cálculo desta Verba:</html>"));

        pnNL2L2c.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnNL2L2c.setLayout(flNL2);
        pnNL2L2c.add(tfPerIn);
        pnNL2L2c.add(tfPerSai);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tfPerIn.setText("06/01/2010");
        tfPerSai.setText("07/01/2010");

        pnNL2L2.add(pnNL2L2c);

        pnNL1.add(pnNL1L1);
        pnNL1.add(pnNL1L2);
        pnNL2.add(pnNL2L1);
        pnNL2.add(pnNL2L2);

        pnSS.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pnSS.add(btSend);
        pnSS.add(btCanc);

        pnS.add(pnSS);

        pnN.add(pnNL1);
        pnN.add(pnNL2);

        //Art. 58
        pn58L1.add(new JLabel("Tempo Total de Acomodação"));
        pn58L1.add(tf58Tot);
        tf58Tot.setText("00:10");
        pn58L2.add(rb58Cond);
        pn58L3.add(rb58Fix);
        rb58Cond.setSelected(true);

        bg58Rb.add(rb58Cond);
        bg58Rb.add(rb58Fix);

        pn58Aux.add(pn58L1);
        pn58Aux.add(pn58L2);
        pn58Aux.add(pn58L3);

        pn58.add(pn58Aux);

        //Art. 66
        pn66Aux.add(ch66Dom);
        pn66Aux.add(ch66Seg);
        pn66Aux.add(ch66Ter);
        pn66Aux.add(ch66Qua);
        pn66Aux.add(ch66Qui);
        pn66Aux.add(ch66Sex);
        pn66Aux.add(ch66Sab);
        pn66Aux.add(ch66Fer);
        ch66Seg.setSelected(true);
        ch66Ter.setSelected(true);
        ch66Qua.setSelected(true);
        ch66Qui.setSelected(true);
        ch66Sex.setSelected(true);
        ch66Sab.setSelected(true);
        ch66Dom.setSelected(true);
        ch66Fer.setSelected(true);

        pn66.add(pn66Aux);

        pn66Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        //Art. 384
        pn384C1L1.add(new JLabel("Tempo de Intervalo: "));
        pn384C1L1.add(tf384Int);
        tf384Int.setText("00:15");

        pn384C1L2.add(new JLabel("Apurar somente se as H.E. for superior a: "));
        pn384C1L2.add(tf384Sup);
        tf384Sup.setText("00:10");

        pn384C1L3.add(ch384Desc);
        ch384Desc.setSelected(true);

        pn384C1L4.add(ch384DiuNot);

        pn384C1L5.add(ch384Dsr);

        pn384C1Aux.add(pn384C1L1);
        pn384C1Aux.add(pn384C1L2);
        pn384C1Aux.add(pn384C1L3);
        pn384C1Aux.add(pn384C1L4);
        pn384C1Aux.add(pn384C1L5);

        pn384C1.add(pn384C1Aux);

        pn384C2Aux.add(ch384Dom);
        pn384C2Aux.add(ch384Seg);
        pn384C2Aux.add(ch384Ter);
        pn384C2Aux.add(ch384Qua);
        pn384C2Aux.add(ch384Qui);
        pn384C2Aux.add(ch384Sex);
        pn384C2Aux.add(ch384Sab);
        pn384C2Aux.add(ch384Fer);

        ch384Dom.setSelected(true);
        ch384Seg.setSelected(true);
        ch384Ter.setSelected(true);
        ch384Qua.setSelected(true);
        ch384Qui.setSelected(true);
        ch384Sex.setSelected(true);
        ch384Sab.setSelected(true);
        ch384Fer.setSelected(true);

        pn384C2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pn384C2.add(pn384C2Aux);

        pn384.add(pn384C1, BorderLayout.CENTER);
        pn384.add(pn384C2, BorderLayout.EAST);

        //Art. 71
        pn71C1L1.add(ch71Min);
        pn71C1L1.add(ch71Max);

        pn71C1L3.add(new JLabel("Intervalo a partir do qual não se apura o Art. 71"));
        pn71C1L3.add(tf71APartir);
        tf71APartir.setEnabled(false);

        pn71C1L4.add(new JLabel("Intervalo máximo a partir do qual se apura o Art. 71"));
        pn71C1L4.add(tf71Max);
        tf71Max.setEnabled(false);

        pn71C1L5.add(rb71Dif);
        pn71C1L5.add(tf71Apurar1);
        rb71Dif.setEnabled(false);
        tf71Apurar1.setEnabled(false);

        pn71C1L6.add(rb71Fix);
        pn71C1L6.add(tf71Apurar2);
        rb71Fix.setEnabled(false);
        tf71Apurar2.setEnabled(false);

        bg71.add(rb71Dif);
        bg71.add(rb71Fix);
        bg71.add(rb71Aux);

        pn71C1L7.add(ch71Exc);
        pn71C1L7.add(tf71Exc);
        pn71C1L7.add(new JLabel(" dias na semana"));
        tf71Exc.setEnabled(false);

        pn71C1L8.add(ch71Semp);
        pn71C1L8.add(tf71Semp);
        pn71C1L8.add(new JLabel(" dias na semana"));
        tf71Semp.setEnabled(false);

        pn71C1L9.add(ch71Apu);

        pn71C1L10.add(ch71Dsr);

        pn71C1Aux.add(pn71C1L1);
        pn71C1Aux.add(new JLabel("   "));
        pn71C1Aux.add(pn71C1L3);
        pn71C1Aux.add(pn71C1L4);
        pn71C1Aux.add(pn71C1L5);
        pn71C1Aux.add(pn71C1L6);
        pn71C1Aux.add(pn71C1L7);
        pn71C1Aux.add(pn71C1L8);
        pn71C1Aux.add(pn71C1L9);

        pn71C2Aux.add(ch71Dom);
        pn71C2Aux.add(ch71Seg);
        pn71C2Aux.add(ch71Ter);
        pn71C2Aux.add(ch71Qua);
        pn71C2Aux.add(ch71Qui);
        pn71C2Aux.add(ch71Sex);
        pn71C2Aux.add(ch71Sab);
        pn71C2Aux.add(ch71Fer);

        ch71Seg.setSelected(true);
        ch71Ter.setSelected(true);
        ch71Qua.setSelected(true);
        ch71Qui.setSelected(true);
        ch71Sex.setSelected(true);
        ch71Sab.setSelected(true);
        ch71Dom.setSelected(true);
        ch71Fer.setSelected(true);

        pn71C2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pn71C1.add(pn71C1Aux);

        pn71C2.add(pn71C2Aux);

        pn71.add(pn71C1, BorderLayout.CENTER);
        pn71.add(pn71C2, BorderLayout.EAST);

        ch71Exc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch71Exc.isSelected()) {
                    ch71Semp.setEnabled(false);
                    tf71Semp.setEnabled(false);
                    tf71Exc.setEnabled(true);
                } else {
                    ch71Semp.setEnabled(true);
                    tf71Exc.setEnabled(false);
                }
            }
        });
        ch71Semp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch71Semp.isSelected()) {
                    ch71Exc.setEnabled(false);
                    tf71Exc.setEnabled(false);
                    tf71Semp.setEnabled(true);
                } else {
                    ch71Exc.setEnabled(true);
                    tf71Semp.setEnabled(false);
                }
            }
        });

        ch71Min.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch71Min.isSelected()) {
                    rb71Dif.setEnabled(true);
                    rb71Fix.setEnabled(true);
                    rb71Dif.setSelected(true);
                    tf71APartir.setEnabled(true);
                    tf71Apurar2.setEnabled(true);
                    tf71Apurar1.setEnabled(true);
                } else {
                    rb71Dif.setEnabled(false);
                    rb71Fix.setEnabled(false);
                    rb71Aux.setSelected(true);
                    tf71APartir.setEnabled(false);
                    tf71Apurar1.setEnabled(false);
                    tf71Apurar2.setEnabled(false);
                }
            }
        });

        ch71Max.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch71Max.isSelected()) {
                    tf71Max.setEnabled(true);
                } else {
                    tf71Max.setEnabled(false);
                }
            }
        });

        tf71Exc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String num = "1234567890";
                int[] i = new int[10];
                int cont = 0;
                boolean b = false;
                for (String s : num.split("|")) {
                    i[cont] = Integer.valueOf(s);
                    cont += 1;
                }
                try {
                    for (int j : i) {
                        if (Integer.parseInt(String.valueOf(e.getKeyChar())) == j) {
                            b = true;
                            break;
                        }
                    }
                } catch (Exception E) {
                    System.out.println("teclou sem ser número");
                    e.consume();
                }
                if (!b) {
                    e.consume();
                }
            }
        });

        tf71Semp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String num = "1234567890";
                int[] i = new int[10];
                int cont = 0;
                boolean b = false;
                for (String s : num.split("|")) {
                    i[cont] = Integer.valueOf(s);
                    cont += 1;
                }
                try {
                    for (int j : i) {
                        if (Integer.parseInt(String.valueOf(e.getKeyChar())) == j) {
                            b = true;
                            break;
                        }
                    }
                } catch (Exception E) {
                    System.out.println("teclou sem ser número");
                    e.consume();
                }
                if (!b) {
                    e.consume();
                }
            }
        });

        //72
        pn72C1L1.add(new JLabel("Tempo de Intervalo"));
        pn72C1L1.add(tf72Int);
        tf72Int.setText("00:10");

        pn72C1L2.add(new JLabel("A cada (Qtd. H. Trabalhada)"));
        pn72C1L2.add(tf72Acad);
        tf72Acad.setText("00:50");

        pn72C1L3.add(ch72Desc);
        ch72Desc.setSelected(true);

        pn72C1L4.add(ch72DiuNotSep);

        pn72C1L5.add(ch72Dsr);

        pn72C1L6.add(ch72AbFolg);
        pn72C1L6.add(tf72LimDe);
        tf72LimDe.setEnabled(false);
        ch72AbFolg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72AbFolg.isSelected()) {
                    tf72LimDe.setEnabled(true);
                } else {
                    tf72LimDe.setEnabled(false);
                }
            }
        });

        pn72C1L7.add(ch72LimCalcA);
        pn72C1L7.add(tf72CalcA);
        pn72C1L7.add(ch72DiasUteisCorridos);
        tf72CalcA.setEnabled(false);
        ch72DiasUteisCorridos.setEnabled(false);
        ch72LimCalcA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72LimCalcA.isSelected()) {
                    tf72CalcA.setEnabled(true);
                    ch72DiasUteisCorridos.setEnabled(true);
                } else {
                    tf72CalcA.setEnabled(false);
                    ch72DiasUteisCorridos.setEnabled(false);
                }
            }
        });

        tf72CalcA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String num = "1234567890";
                int[] i = new int[10];
                int cont = 0;
                boolean b = false;
                for (String s : num.split("|")) {
                    i[cont] = Integer.valueOf(s);
                    cont += 1;
                }
                try {
                    for (int j : i) {
                        if (Integer.parseInt(String.valueOf(e.getKeyChar())) == j) {
                            b = true;
                            break;
                        }
                    }
                } catch (Exception E) {
                    System.out.println("teclou sem ser número");
                    e.consume();
                }
                if (!b) {
                    e.consume();
                }
            }
        });

        pn72C1L8.add(ch72LimCalcAte);
        pn72C1L8.add(tf72LimCalcAte);
        pn72C1L8.add(new JLabel("Horas Trabalhadas"));
        tf72LimCalcAte.setEnabled(false);
        ch72LimCalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72LimCalcAte.isSelected()) {
                    tf72LimCalcAte.setEnabled(true);
                } else {
                    tf72LimCalcAte.setEnabled(false);
                }
            }
        });

        pn72C1L9.add(ch72CalcAte);
        pn72C1L9.add(tf72CalcAte);
        pn72C1L9.add(new JLabel("Horas (horários limite no final do expediente)"));
        tf72CalcAte.setEnabled(false);
        ch72CalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72CalcAte.isSelected()) {
                    tf72CalcAte.setEnabled(true);
                } else {
                    tf72CalcAte.setEnabled(false);
                }
            }
        });

        pn72C1L10.add(ch72CalcApart);
        pn72C1L10.add(tf72CalcApart);
        pn72C1L10.add(new JLabel("Horas (horários a partir do qual será calculado)"));
        tf72CalcApart.setEnabled(false);
        ch72CalcApart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72CalcApart.isSelected()) {
                    tf72CalcApart.setEnabled(true);
                } else {
                    tf72CalcApart.setEnabled(false);
                }
            }
        });

        pn72C1L11.add(ch72IntFirst);
        pn72C1L11.add(tf72IntFixFirst);
        pn72C1L11.add(new JLabel("<html>Horas (Tempo máximo a pagar na<br> primeira semana)</html>"));
        tf72IntFixFirst.setEnabled(false);
        ch72IntFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72IntFirst.isSelected()) {
                    tf72IntFixFirst.setEnabled(true);
                } else {
                    tf72IntFixFirst.setEnabled(false);
                }
            }
        });

        pn72C1L12.add(ch72IntSeg);
        pn72C1L12.add(tf72IntFixSeg);
        pn72C1L12.add(new JLabel("<html>Horas (Tempo máximo a pagar na segunda<br> semana intercalada com a primeira semana)</html>"));
        tf72IntFixSeg.setEnabled(false);
        ch72IntSeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch72IntSeg.isSelected()) {
                    tf72IntFixSeg.setEnabled(true);
                } else {
                    tf72IntFixSeg.setEnabled(false);
                }
            }
        });

        pn72C1Aux.add(pn72C1L1);
        pn72C1Aux.add(pn72C1L2);
        pn72C1Aux.add(pn72C1L3);
        pn72C1Aux.add(pn72C1L4);
        pn72C1Aux.add(pn72C1L5);
        pn72C1Aux.add(pn72C1L6);
        pn72C1Aux.add(pn72C1L7);
        pn72C1Aux.add(pn72C1L8);
        pn72C1Aux.add(pn72C1L9);
        pn72C1Aux.add(pn72C1L10);
        pn72C1Aux.add(pn72C1L11);
        pn72C1Aux.add(pn72C1L12);

        pn72C2Aux.add(ch72Dom);
        pn72C2Aux.add(ch72Seg);
        pn72C2Aux.add(ch72Ter);
        pn72C2Aux.add(ch72Qua);
        pn72C2Aux.add(ch72Qui);
        pn72C2Aux.add(ch72Sex);
        pn72C2Aux.add(ch72Sab);
        pn72C2Aux.add(ch72Fer);

        ch72Dom.setSelected(true);
        ch72Seg.setSelected(true);
        ch72Ter.setSelected(true);
        ch72Qua.setSelected(true);
        ch72Qui.setSelected(true);
        ch72Sex.setSelected(true);
        ch72Sab.setSelected(true);
        ch72Fer.setSelected(true);

        pn72C1.add(pn72C1Aux);

        pn72C2.add(pn72C2Aux);

        pn72C2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pn72.add(pn72C1, BorderLayout.CENTER);
        pn72.add(pn72C2, BorderLayout.EAST);

        //Art. 253
        pn253C1L1.add(new JLabel("Tempo de Intervalo"));
        pn253C1L1.add(tf253Int);
        tf253Int.setText("00:20");

        pn253C1L2.add(new JLabel("A cada (Qtd. H. Trabalhada)"));
        pn253C1L2.add(tf253Acad);
        tf253Acad.setText("01:40");

        pn253C1L3.add(ch253Desc);
        ch253Desc.setSelected(true);

        pn253C1L4.add(ch253DiuNotSep);

        pn253C1L5.add(ch253Dsr);

        pn253C1L6.add(ch253AbFolg);
        pn253C1L6.add(tf253LimDe);
        tf253LimDe.setEnabled(false);
        ch253AbFolg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253AbFolg.isSelected()) {
                    tf253LimDe.setEnabled(true);
                } else {
                    tf253LimDe.setEnabled(false);
                }
            }
        });

        pn253C1L7.add(ch253LimCalcA);
        pn253C1L7.add(tf253CalcA);
        pn253C1L7.add(ch253DiasUteisCorridos);
        tf253CalcA.setEnabled(false);
        ch253DiasUteisCorridos.setEnabled(false);
        ch253LimCalcA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253LimCalcA.isSelected()) {
                    tf253CalcA.setEnabled(true);
                    ch253DiasUteisCorridos.setEnabled(true);
                } else {
                    tf253CalcA.setEnabled(false);
                    ch253DiasUteisCorridos.setEnabled(false);
                }
            }
        });

        pn253C1L8.add(ch253LimCalcAte);
        pn253C1L8.add(tf253LimCalcAte);
        pn253C1L8.add(new JLabel("Horas Trabalhadas"));
        tf253LimCalcAte.setEnabled(false);
        ch253LimCalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253LimCalcAte.isSelected()) {
                    tf253LimCalcAte.setEnabled(true);
                } else {
                    tf253LimCalcAte.setEnabled(false);
                }
            }
        });

        pn253C1L9.add(ch253CalcAte);
        pn253C1L9.add(tf253CalcAte);
        pn253C1L9.add(new JLabel("Horas (horários limite no final do expediente)"));
        tf253CalcAte.setEnabled(false);
        ch253CalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253CalcAte.isSelected()) {
                    tf253CalcAte.setEnabled(true);
                } else {
                    tf253CalcAte.setEnabled(false);
                }
            }
        });

        pn253C1L10.add(ch253CalcApart);
        pn253C1L10.add(tf253CalcApart);
        pn253C1L10.add(new JLabel("Horas (horários a partir do qual será calculado)"));
        tf253CalcApart.setEnabled(false);
        ch253CalcApart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253CalcApart.isSelected()) {
                    tf253CalcApart.setEnabled(true);
                } else {
                    tf253CalcApart.setEnabled(false);
                }
            }
        });

        pn253C1L11.add(ch253IntFirst);
        pn253C1L11.add(tf253IntFixFirst);
        pn253C1L11.add(new JLabel("<html>Horas (Tempo máximo a pagar na<br> primeira semana)</html>"));
        tf253IntFixFirst.setEnabled(false);
        ch253IntFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253IntFirst.isSelected()) {
                    tf253IntFixFirst.setEnabled(true);
                } else {
                    tf253IntFixFirst.setEnabled(false);
                }
            }
        });

        pn253C1L12.add(ch253IntSeg);
        pn253C1L12.add(tf253IntFixSeg);
        pn253C1L12.add(new JLabel("<html>Horas (Tempo máximo a pagar na segunda<br> semana intercalada com a primeira semana)</html>"));
        tf253IntFixSeg.setEnabled(false);
        ch253IntSeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch253IntSeg.isSelected()) {
                    tf253IntFixSeg.setEnabled(true);
                } else {
                    tf253IntFixSeg.setEnabled(false);
                }
            }
        });

        pn253C1Aux.add(pn253C1L1);
        pn253C1Aux.add(pn253C1L2);
        pn253C1Aux.add(pn253C1L3);
        pn253C1Aux.add(pn253C1L4);
        pn253C1Aux.add(pn253C1L5);
        pn253C1Aux.add(pn253C1L6);
        pn253C1Aux.add(pn253C1L7);
        pn253C1Aux.add(pn253C1L8);
        pn253C1Aux.add(pn253C1L9);
        pn253C1Aux.add(pn253C1L10);
        pn253C1Aux.add(pn253C1L11);
        pn253C1Aux.add(pn253C1L12);

        pn253C2Aux.add(ch253Dom);
        pn253C2Aux.add(ch253Seg);
        pn253C2Aux.add(ch253Ter);
        pn253C2Aux.add(ch253Qua);
        pn253C2Aux.add(ch253Qui);
        pn253C2Aux.add(ch253Sex);
        pn253C2Aux.add(ch253Sab);
        pn253C2Aux.add(ch253Fer);

        ch253Dom.setSelected(true);
        ch253Seg.setSelected(true);
        ch253Ter.setSelected(true);
        ch253Qua.setSelected(true);
        ch253Qui.setSelected(true);
        ch253Sex.setSelected(true);
        ch253Sab.setSelected(true);
        ch253Fer.setSelected(true);

        pn253C1.add(pn253C1Aux);

        pn253C2.add(pn253C2Aux);

        pn253C2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pn253.add(pn253C1, BorderLayout.CENTER);
        pn253.add(pn253C2, BorderLayout.EAST);

        //nr 36
        pn36C1L1.add(ch366h);
        pn36C1L1.add(tf366h);
        ch366h.setSelected(true);
        tf366h.setText("00:20");
        ch366h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch366h.isSelected()) {
                    tf366h.setEnabled(true);
                } else {
                    tf366h.setEnabled(false);
                }
            }
        });

        pn36C1L2.add(ch367h);
        pn36C1L2.add(tf367h);
        ch367h.setSelected(true);
        tf367h.setText("00:45");
        ch367h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch367h.isSelected()) {
                    tf367h.setEnabled(true);
                } else {
                    tf367h.setEnabled(false);
                }
            }
        });

        pn36C1L3.add(ch369h10);
        pn36C1L3.add(tf369h10);
        ch369h10.setSelected(true);
        tf369h10.setText("01:00");
        ch369h10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch369h10.isSelected()) {
                    tf369h10.setEnabled(true);
                } else {
                    tf369h10.setEnabled(false);
                }
            }
        });

        pn36C1L4.add(ch369h50);
        pn36C1L4.add(tf369h50);
        ch369h50.setSelected(true);
        tf369h50.setText("00:10");
        ch369h50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch369h50.isSelected()) {
                    tf369h50.setEnabled(true);
                } else {
                    tf369h50.setEnabled(false);
                }
            }
        });

        pn36C1L5.add(ch36M9h50);
        ch36M9h50.setSelected(true);
        ch36M9h50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36M9h50.isSelected()) {
                    tf36Int.setEnabled(true);
                    tf36Acad.setEnabled(true);
                } else {
                    tf36Int.setEnabled(false);
                    tf36Acad.setEnabled(false);
                }
            }
        });

        pn36C1L6.add(new JLabel("Tempo de Intervalo"));
        pn36C1L6.add(tf36Int);
        tf36Int.setText("00:10");

        pn36C1L7.add(new JLabel("A cada (Qtd. H. Trabalhada)"));
        pn36C1L7.add(tf36Acad);
        tf36Acad.setText("00:50");

        pn36C1L8.add(ch36Desc);
        ch36Desc.setSelected(true);

        pn36C1L9.add(ch36DiuNotSep);

        pn36C1L10.add(ch36Dsr);

        pn36C1L11.add(ch36AbFolg);
        pn36C1L11.add(tf36LimDe);
        tf36LimDe.setEnabled(false);
        ch36AbFolg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36AbFolg.isSelected()) {
                    tf36LimDe.setEnabled(true);
                } else {
                    tf36LimDe.setEnabled(false);
                }
            }
        });

        pn36C1L12.add(ch36LimCalcA);
        pn36C1L12.add(tf36CalcA);
        pn36C1L12.add(ch36DiasUteisCorridos);
        tf36CalcA.setEnabled(false);
        ch36DiasUteisCorridos.setEnabled(false);
        ch36LimCalcA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36LimCalcA.isSelected()) {
                    tf36CalcA.setEnabled(true);
                    ch36DiasUteisCorridos.setEnabled(true);
                } else {
                    tf36CalcA.setEnabled(false);
                    ch36DiasUteisCorridos.setEnabled(false);
                }
            }
        });

        pn36C1L13.add(ch36LimCalcAte);
        pn36C1L13.add(tf36LimCalcAte);
        pn36C1L13.add(new JLabel("Horas Trabalhadas"));
        tf36LimCalcAte.setEnabled(false);
        ch36LimCalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36LimCalcAte.isSelected()) {
                    tf36LimCalcAte.setEnabled(true);
                } else {
                    tf36LimCalcAte.setEnabled(false);
                }
            }
        });

        pn36C1L14.add(ch36CalcAte);
        pn36C1L14.add(tf36CalcAte);
        pn36C1L14.add(new JLabel("Horas (horários limite no final do expediente)"));
        tf36CalcAte.setEnabled(false);
        ch36CalcAte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36CalcAte.isSelected()) {
                    tf36CalcAte.setEnabled(true);
                } else {
                    tf36CalcAte.setEnabled(false);
                }
            }
        });

        pn36C1L15.add(ch36CalcApart);
        pn36C1L15.add(tf36CalcApart);
        pn36C1L15.add(new JLabel("Horas (horários a partir do qual será calculado)"));
        tf36CalcApart.setEnabled(false);
        ch36CalcApart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36CalcApart.isSelected()) {
                    tf36CalcApart.setEnabled(true);
                } else {
                    tf36CalcApart.setEnabled(false);
                }
            }
        });

        pn36C1L16.add(ch36IntFirst);
        pn36C1L16.add(tf36IntFixFirst);
        pn36C1L16.add(new JLabel("<html>Horas (Tempo máximo a pagar na<br> primeira semana)</html>"));
        tf36IntFixFirst.setEnabled(false);
        ch36IntFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36IntFirst.isSelected()) {
                    tf36IntFixFirst.setEnabled(true);
                } else {
                    tf36IntFixFirst.setEnabled(false);
                }
            }
        });

        pn36C1L17.add(ch36IntSeg);
        pn36C1L17.add(tf36IntFixSeg);
        pn36C1L17.add(new JLabel("<html>Horas (Tempo máximo a pagar na segunda<br> semana intercalada com a primeira semana)</html>"));
        tf36IntFixSeg.setEnabled(false);
        ch36IntSeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch36IntSeg.isSelected()) {
                    tf36IntFixSeg.setEnabled(true);
                } else {
                    tf36IntFixSeg.setEnabled(false);
                }
            }
        });

        pn36C1Aux.add(pn36C1L1);
        pn36C1Aux.add(pn36C1L2);
        pn36C1Aux.add(pn36C1L3);
        pn36C1Aux.add(pn36C1L4);
        pn36C1Aux.add(pn36C1L5);
        pn36C1Aux.add(pn36C1L6);
        pn36C1Aux.add(pn36C1L7);
        pn36C1Aux.add(pn36C1L8);
        pn36C1Aux.add(pn36C1L9);
        pn36C1Aux.add(pn36C1L10);
        pn36C1Aux.add(pn36C1L11);
        pn36C1Aux.add(pn36C1L12);
        pn36C1Aux.add(pn36C1L13);
        pn36C1Aux.add(pn36C1L14);
        pn36C1Aux.add(pn36C1L15);
        pn36C1Aux.add(pn36C1L16);
        pn36C1Aux.add(pn36C1L17);

        pn36C2Aux.add(ch36Dom);
        pn36C2Aux.add(ch36Seg);
        pn36C2Aux.add(ch36Ter);
        pn36C2Aux.add(ch36Qua);
        pn36C2Aux.add(ch36Qui);
        pn36C2Aux.add(ch36Sex);
        pn36C2Aux.add(ch36Sab);
        pn36C2Aux.add(ch36Fer);

        ch36Dom.setSelected(true);
        ch36Seg.setSelected(true);
        ch36Ter.setSelected(true);
        ch36Qua.setSelected(true);
        ch36Qui.setSelected(true);
        ch36Sex.setSelected(true);
        ch36Sab.setSelected(true);
        ch36Fer.setSelected(true);

        pn36C1.add(pn36C1Aux);

        pn36C2.add(pn36C2Aux);

        pn36C2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pn36.add(pn36C1, BorderLayout.CENTER);
        pn36.add(pn36C2, BorderLayout.EAST);

        //adicionar horário ni Início/Fim da Jornada
        pnAdcC1L1.add(new JLabel("Descrição da Verba: "));
        pnAdcC1L1.add(tfAdcDesc);

        pnAdcC1L2.add(new JLabel("<html>Qtd. Tempo a Adicionar antes do<br>início da Jornada</html>"));
        pnAdcC1L2.add(tfAdcQntAnt);
        pnAdcC1L2.add(chAdcAntSe);
        pnAdcC1L2.add(tfAdcQntAntSe);
        tfAdcQntAntSe.setEnabled(false);
        tfAdcQntAnt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String num = "1234567890";
                int[] i = new int[10];
                int cont = 0;
                boolean b = false;
                for (String s : num.split("|")) {
                    i[cont] = Integer.valueOf(s);
                    cont += 1;
                }
                try {
                    for (int j : i) {
                        if (Integer.parseInt(String.valueOf(e.getKeyChar())) == j) {
                            b = true;
                            break;
                        }
                    }
                } catch (Exception E) {
                    System.out.println("teclou sem ser numero");
                    e.consume();
                }
                if (!b) {
                    e.consume();
                }
                if ((tfAdcQntAnt.getCaretPosition() == 2 && tfAdcQntAnt.getText().length() == 2) || (tfAdcQntAnt.getCaretPosition() == 2 && !tfAdcQntAnt.getText().substring(2, 3).equals(":"))) {
                    tfAdcQntAnt.setText(tfAdcQntAnt.getText().replace(" ", "") + ":");
                    tfAdcQntAnt.setCaretPosition(3);
                } else if (tfAdcQntAnt.getCaretPosition() == 2) {
                    tfAdcQntAnt.setCaretPosition(3);
                }
            }
        });

        pnAdcC1L3.add(new JLabel("<html>Qtd. Tempo a Adicionar Após o<br>Término da Jornada"));
        pnAdcC1L3.add(tfAdcQntDps);
        pnAdcC1L3.add(chAdcDpsSe);
        pnAdcC1L3.add(tfAdcQntDpsSe);
        tfAdcQntDpsSe.setEnabled(false);
        tfAdcQntDps.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String num = "1234567890";
                int[] i = new int[10];
                int cont = 0;
                boolean b = false;
                for (String s : num.split("|")) {
                    i[cont] = Integer.valueOf(s);
                    cont += 1;
                }
                try {
                    for (int j : i) {
                        if (Integer.parseInt(String.valueOf(e.getKeyChar())) == j) {
                            b = true;
                            break;
                        }
                    }
                } catch (Exception E) {
                    System.out.println("teclou sem ser numero");
                    e.consume();
                }
                if (!b) {
                    e.consume();
                }
                if ((tfAdcQntDps.getCaretPosition() == 2 && tfAdcQntDps.getText().length() == 2) || (tfAdcQntDps.getCaretPosition() == 2 && !tfAdcQntDps.getText().substring(2, 3).equals(":"))) {
                    tfAdcQntDps.setText(tfAdcQntDps.getText().replace(" ", "") + ":");
                    tfAdcQntDps.setCaretPosition(3);
                } else if (tfAdcQntDps.getCaretPosition() == 2) {
                    tfAdcQntDps.setCaretPosition(3);
                }
            }
        });

        pnAdcC1L4.add(chAdcDiu);
        pnAdcC1L5.add(chAdcDsr);
        pnAdcC1L6.add(chAdcExcDia);
        pnAdcC1L7.add(chAdcExcSem);
        pnAdcC1L8.add(chAdcExcDiSe);

        pnAdcC1Aux.add(pnAdcC1L1);
        pnAdcC1Aux.add(pnAdcC1L2);
        pnAdcC1Aux.add(pnAdcC1L3);
        pnAdcC1Aux.add(pnAdcC1L4);
        pnAdcC1Aux.add(pnAdcC1L5);
        pnAdcC1Aux.add(pnAdcC1L6);
        pnAdcC1Aux.add(pnAdcC1L7);
        pnAdcC1Aux.add(pnAdcC1L8);

        pnAdcC1.add(pnAdcC1Aux);

        pnAdcC2Aux.add(chAdcDom);
        pnAdcC2Aux.add(chAdcSeg);
        pnAdcC2Aux.add(chAdcTer);
        pnAdcC2Aux.add(chAdcQua);
        pnAdcC2Aux.add(chAdcQui);
        pnAdcC2Aux.add(chAdcSex);
        pnAdcC2Aux.add(chAdcSab);
        pnAdcC2Aux.add(chAdcFer);

        chAdcDom.setSelected(true);
        chAdcSeg.setSelected(true);
        chAdcTer.setSelected(true);
        chAdcQua.setSelected(true);
        chAdcQui.setSelected(true);
        chAdcSex.setSelected(true);
        chAdcSab.setSelected(true);
        chAdcFer.setSelected(true);

        pnAdcC2Aux.setBorder(BorderFactory.createLoweredBevelBorder());

        pnAdcC2.add(pnAdcC2Aux);

        chAdcAntSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcAntSe.isSelected()) {
                    tfAdcQntAntSe.setEnabled(true);
                } else {
                    tfAdcQntAntSe.setEnabled(false);

                }
            }
        });
        chAdcDpsSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcDpsSe.isSelected()) {
                    tfAdcQntDpsSe.setEnabled(true);
                } else {
                    tfAdcQntDpsSe.setEnabled(false);
                }
            }
        });
        chAdcExcDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcExcDia.isSelected()) {
                    chAdcExcDiSe.setEnabled(false);
                    chAdcExcSem.setEnabled(false);
                    chAdcExcDiSe.setSelected(false);
                    chAdcExcSem.setSelected(false);
                } else {
                    chAdcExcDiSe.setEnabled(true);
                    chAdcExcSem.setEnabled(true);
                }
            }
        });
        chAdcExcSem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcExcSem.isSelected()) {
                    chAdcExcDia.setEnabled(false);
                    chAdcExcDiSe.setEnabled(false);
                    chAdcExcDia.setSelected(false);
                    chAdcExcDiSe.setSelected(false);
                } else {
                    chAdcExcDia.setEnabled(true);
                    chAdcExcDiSe.setEnabled(true);
                }
            }
        });
        chAdcExcDiSe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcExcDiSe.isSelected()) {
                    chAdcExcDia.setEnabled(false);
                    chAdcExcSem.setEnabled(false);
                    chAdcExcDia.setSelected(false);
                    chAdcExcSem.setSelected(false);
                } else {
                    chAdcExcDia.setEnabled(true);
                    chAdcExcSem.setEnabled(true);
                }
            }
        });

        tfAdcDesc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tfAdcDesc.getText().trim().length() > 10) {
                    JOptionPane.showMessageDialog(null, "O campo é limitado a apenas 10 caracteres!");
                    tfAdcDesc.setText(tfAdcDesc.getText().trim().substring(0, tfAdcDesc.getText().trim().length() - 1));
                    tfAdcDesc.requestFocus();
                }
            }
        });

        pnAdc.add(pnAdcC1, BorderLayout.CENTER);
        pnAdc.add(pnAdcC2, BorderLayout.EAST);

        //Súmula 85
        pnSumC1L1.add(new JLabel("Jornada a partir do qual haverá compensação: "));
        pnSumC1L1.add(tfSumJorn);
        tfSumJorn.setText("08:00");

        pnSumC1L2.add(new JLabel("Tempo máximo destinado à compensação: "));
        pnSumC1L2.add(tfSumTemp);
        tfSumTemp.setText("00:48");

        pnSumC1L3.add(new JLabel("<html>Qnt. folga semanal a partir da qual não<br>haverá apuração das horas a compensar"));
        pnSumC1L3.add(tfSumQnt);
        tfSumQnt.setText("2");

        pnSumC1L4.add(chSumApu);

        pnSumC1L.add(pnSumC1L1);
        pnSumC1L.add(pnSumC1L2);
        pnSumC1L.add(pnSumC1L3);
        pnSumC1L.add(pnSumC1L4);

        pnSumC2L.add(chSumCondDom);
        pnSumC2L.add(chSumCondSeg);
        pnSumC2L.add(chSumCondTer);
        pnSumC2L.add(chSumCondQua);
        pnSumC2L.add(chSumCondQui);
        pnSumC2L.add(chSumCondSex);
        pnSumC2L.add(chSumCondSab);
        pnSumC2L.add(chSumCondFer);

        pnSumC3L.add(chSumApuDom);
        pnSumC3L.add(chSumApuSeg);
        pnSumC3L.add(chSumApuTer);
        pnSumC3L.add(chSumApuQua);
        pnSumC3L.add(chSumApuQui);
        pnSumC3L.add(chSumApuSex);
        pnSumC3L.add(chSumApuSab);
        pnSumC3L.add(chSumApuFer);

        pnSumC1.add(pnSumC1L);
        pnSumC2.add(pnSumC2L);
        pnSumC3.add(pnSumC3L);

        pnSumC2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Labor Condição p/ Cálculo"));
        pnSumC3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Dias a Apurar a Compensação"));

        pnSumAux.add(pnSumC2);
        pnSumAux.add(new JLabel("      "));
        pnSumAux.add(pnSumC3);

        pnSum.add(pnSumC1, BorderLayout.CENTER);
        pnSum.add(pnSumAux, BorderLayout.EAST);

        chSumCondDom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondDom.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondSeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondSeg.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondDom.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondTer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondTer.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondDom.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondQua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondQua.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondDom.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondQui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondQui.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondDom.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondSex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondSex.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondDom.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondSab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondSab.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondDom.isSelected()
                        && !chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        chSumCondFer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chSumCondFer.isSelected()) {
                    tfSumQnt.setEnabled(false);
                } else if (!chSumCondSeg.isSelected()
                        && !chSumCondTer.isSelected()
                        && !chSumCondQua.isSelected()
                        && !chSumCondQui.isSelected()
                        && !chSumCondSex.isSelected()
                        && !chSumCondSab.isSelected()
                        && !chSumCondDom.isSelected()) {
                    tfSumQnt.setEnabled(true);
                }
            }
        });

        //Adicional Noturno
        pnAdcNotC1L1.add(chAdcNotExt);
        pnAdcNotC1L2.add(chAdcNotApu);
        pnAdcNotC1L3.add(chAdcNotRed);

        pnAdcNotC1L4.add(new JLabel("Hora Noturna das "));
        pnAdcNotC1L4.add(tfAdcNotHorDas);

        pnAdcNotC1L4.add(new JLabel(" às "));
        pnAdcNotC1L4.add(tfAdcNotHorAs);

        pnAdcNotC1L5.add(chAdcNotNor);

        chAdcNotRed.setSelected(true);
        tfAdcNotHorDas.setEnabled(true);
        tfAdcNotHorAs.setEnabled(true);
        if (tfAdcNotHorDas.isEnabled()
                && tfAdcNotHorAs.isEnabled()) {
            tfAdcNotHorDas.setText("22:00");
            tfAdcNotHorAs.setText("05:00");
        } else {
            tfAdcNotHorDas.setText("");
            tfAdcNotHorAs.setText("");
        }

        pnAdcNotC2Aux.add(chAdcNotDom);
        pnAdcNotC2Aux.add(chAdcNotSeg);
        pnAdcNotC2Aux.add(chAdcNotTer);
        pnAdcNotC2Aux.add(chAdcNotQua);
        pnAdcNotC2Aux.add(chAdcNotQui);
        pnAdcNotC2Aux.add(chAdcNotSex);
        pnAdcNotC2Aux.add(chAdcNotSab);
        pnAdcNotC2Aux.add(chAdcNotFer);

        chAdcNotDom.setSelected(true);
        chAdcNotSeg.setSelected(true);
        chAdcNotTer.setSelected(true);
        chAdcNotQua.setSelected(true);
        chAdcNotQui.setSelected(true);
        chAdcNotSex.setSelected(true);
        chAdcNotSab.setSelected(true);
        chAdcNotFer.setSelected(true);

        pnAdcNotC1Aux.add(pnAdcNotC1L1);
        pnAdcNotC1Aux.add(pnAdcNotC1L2);
        pnAdcNotC1Aux.add(pnAdcNotC1L3);
        pnAdcNotC1Aux.add(pnAdcNotC1L4);
        pnAdcNotC1Aux.add(pnAdcNotC1L5);
        pnAdcNotC1.add(pnAdcNotC1Aux);

        pnAdcNotC2Aux.setBorder(BorderFactory.createLoweredBevelBorder());
        pnAdcNotC2.add(pnAdcNotC2Aux);

        pnAdcNot.add(pnAdcNotC1, BorderLayout.CENTER);
        pnAdcNot.add(pnAdcNotC2, BorderLayout.EAST);

        chAdcNotRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcNotRed.isSelected()) {
                    tfAdcNotHorDas.setEnabled(true);
                    tfAdcNotHorAs.setEnabled(true);
                } else {
                    tfAdcNotHorDas.setEnabled(false);
                    tfAdcNotHorAs.setEnabled(false);
                }
            }
        });
        chAdcNotApu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcNotApu.isSelected()) {
                    chAdcNotExt.setEnabled(false);
                } else {
                    chAdcNotExt.setEnabled(true);
                }
            }
        });
        chAdcNotExt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chAdcNotExt.isSelected()) {
                    chAdcNotApu.setEnabled(false);
                } else {
                    chAdcNotApu.setEnabled(true);
                }
            }
        });

        //Horas Extras
        pnHeC1L1.add(chHeDiario);
        pnHeC1L2.add(chHeSemana);
        pnHeC1L3.add(chHeDiaSem);
        pnHeC1L4.add(chHeDiuNot);
        pnHeC1L5.add(chHeDsr);
        pnHeC1L6.add(chHeNotSep);
        pnHeC1L7.add(chHeEncerr);
        pnHeC1L8.add(chHeDupTri);
        pnHeC1L8.add(tfHeFaixa1);
        pnHeC1L8.add(tfHeFaixa2);

        tfHeFaixa1.setEnabled(false);
        tfHeFaixa2.setEnabled(false);

        pnHeSemSeg.add(chHeSeg);
        chHeSeg.setSelected(true);
        pnHeSemSeg.add(tfHeSeg);
        pnHeSemSeg.add(chHeSegAp);

        pnHeSemTer.add(chHeTer);
        chHeTer.setSelected(true);
        pnHeSemTer.add(tfHeTer);
        pnHeSemTer.add(chHeTerAp);

        pnHeSemQua.add(chHeQua);
        chHeQua.setSelected(true);
        pnHeSemQua.add(tfHeQua);
        pnHeSemQua.add(chHeQuaAp);

        pnHeSemQui.add(chHeQui);
        chHeQui.setSelected(true);
        pnHeSemQui.add(tfHeQui);
        pnHeSemQui.add(chHeQuiAp);

        pnHeSemSex.add(chHeSex);
        chHeSex.setSelected(true);
        pnHeSemSex.add(tfHeSex);
        pnHeSemSex.add(chHeSexAp);

        pnHeSemSab.add(chHeSab);
        chHeSab.setSelected(true);
        pnHeSemSab.add(tfHeSab);
        pnHeSemSab.add(chHeSabAp);

        pnHeSemDom.add(chHeDom);
        chHeDom.setSelected(true);
        pnHeSemDom.add(tfHeDom);
        pnHeSemDom.add(chHeDomAp);

        pnHeSemFer.add(chHeFer);
        chHeFer.setSelected(true);
        pnHeSemFer.add(tfHeFer);
        pnHeSemFer.add(chHeFerAp);

        pnHeSemAux.add(pnHeSemDom);
        pnHeSemAux.add(pnHeSemSeg);
        pnHeSemAux.add(pnHeSemTer);
        pnHeSemAux.add(pnHeSemQua);
        pnHeSemAux.add(pnHeSemQui);
        pnHeSemAux.add(pnHeSemSex);
        pnHeSemAux.add(pnHeSemSab);
        pnHeSemAux.add(pnHeSemFer);
        pnHeSem.add(pnHeSemAux);
        pnHeSemAux.setBorder(BorderFactory.createLoweredBevelBorder());

        //adicionado
        JPanel painelAdicional = new JPanel(new GridLayout(2, 2, 0, 0));
        JPanel painel02 = new JPanel(new GridLayout(3, 1,0,0));
        JCheckBox chk01 = new JCheckBox("opcao 1");
        JCheckBox chk02 = new JCheckBox("opcao 2");
        JCheckBox chk03 = new JCheckBox("opcao 3");
        painel02.add(chk01);
        painel02.add(chk02);
        painel02.add(chk03);
//        painelAdicional.add(pnHeC1L1);
//        painelAdicional.add(painel02);
//        painelAdicional.add(pnHeC1L2);
//       pnHeC1Aux.add(painelAdicional);
        //modificado
//        pnHeC1Aux.add(pnHeC1L1);
//        pnHeC1Aux.add(pnHeC1L2);
        pnHeC1Aux.add(pnHeC1L3);
        pnHeC1Aux.add(pnHeC1L4);
        pnHeC1Aux.add(pnHeC1L5);
        pnHeC1Aux.add(pnHeC1L6);
        pnHeC1Aux.add(pnHeC1L7);
        pnHeC1Aux.add(pnHeC1L8);

        pnHeC1.add(pnHeC1Aux);

        pnHe.add(pnHeC1, BorderLayout.CENTER);
        pnHe.add(pnHeSem, BorderLayout.EAST);

        tfHeFaixa2.addFocusListener(
                new FocusListener() {
            @Override
            public void focusGained(FocusEvent e
            ) {
                if (tfHeFaixa1.getText().trim().equals(":") || tfHeFaixa1.getText().trim().length() < 5) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite a primeira faixa antes!");
                    tfHeFaixa1.requestFocus();
                }
            }

            @Override
            public void focusLost(FocusEvent e
            ) {

            }
        });

        chHeDupTri.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeDupTri.isSelected()) {
                    tfHeFaixa1.setEnabled(true);
                    tfHeFaixa2.setEnabled(true);
                } else {
                    tfHeFaixa1.setEnabled(false);
                    tfHeFaixa2.setEnabled(false);
                }
            }
        }
        );

        tfHeSeg.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeSeg.setText(tfHeSeg.getText().substring(0, tfHeSeg.getText().length() - 1));
                    tfHeSeg.requestFocus();
                } else if (!tfHeSeg.getText().trim().equals("")) {
                    if (tfHeSeg.getText().substring(tfHeSeg.getText().length() - 1).equals(".")) {
                        String g = tfHeSeg.getText().substring(0, tfHeSeg.getText().length() - 1);
                        g += ",";
                        tfHeSeg.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeSeg.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeSeg.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeSeg.getText().trim().equals("")) {
                            if (tfHeSeg.getText().trim().equals(",")) {
//                                tfHeSeg.setText(stT.verPorc(tfHeSeg.getText().trim()));
                            } else if (Double.parseDouble(tfHeSeg.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeSeg.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeSeg.requestFocus();
                            } else {
//                                tfHeSeg.setText(stT.verPorc(tfHeSeg.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeSeg.requestFocus();
                    }
                }
            }
        }
        );

        tfHeTer.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeTer.setText(tfHeTer.getText().substring(0, tfHeTer.getText().length() - 1));
                    tfHeTer.requestFocus();
                } else if (!tfHeTer.getText().trim().equals("")) {
                    if (tfHeTer.getText().substring(tfHeTer.getText().length() - 1).equals(".")) {
                        String g = tfHeTer.getText().substring(0, tfHeTer.getText().length() - 1);
                        g += ",";
                        tfHeTer.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeTer.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeTer.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeTer.getText().trim().equals("")) {
                            if (tfHeTer.getText().trim().equals(",")) {
//                                tfHeTer.setText(stT.verPorc(tfHeTer.getText().trim()));
                            } else if (Double.parseDouble(tfHeTer.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeTer.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeTer.requestFocus();
                            } else {
//                                tfHeTer.setText(stT.verPorc(tfHeTer.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeTer.requestFocus();
                    }
                }
            }
        }
        );

        tfHeQua.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeQua.setText(tfHeQua.getText().substring(0, tfHeQua.getText().length() - 1));
                    tfHeQua.requestFocus();
                } else if (!tfHeQua.getText().trim().equals("")) {
                    if (tfHeQua.getText().substring(tfHeQua.getText().length() - 1).equals(".")) {
                        String g = tfHeQua.getText().substring(0, tfHeQua.getText().length() - 1);
                        g += ",";
                        tfHeQua.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeQua.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeQua.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeQua.getText().trim().equals("")) {
                            if (tfHeQua.getText().trim().equals(",")) {
//                                tfHeQua.setText(stT.verPorc(tfHeQua.getText().trim()));
                            } else if (Double.parseDouble(tfHeQua.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeQua.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeQua.requestFocus();
                            } else {
//                                tfHeQua.setText(stT.verPorc(tfHeQua.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeQua.requestFocus();
                    }
                }
            }
        }
        );

        tfHeQui.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeQui.setText(tfHeQui.getText().substring(0, tfHeQui.getText().length() - 1));
                    tfHeQui.requestFocus();
                } else if (!tfHeQui.getText().trim().equals("")) {
                    if (tfHeQui.getText().substring(tfHeQui.getText().length() - 1).equals(".")) {
                        String g = tfHeQui.getText().substring(0, tfHeQui.getText().length() - 1);
                        g += ",";
                        tfHeQui.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeQui.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeQui.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeQui.getText().trim().equals("")) {
                            if (tfHeQui.getText().trim().equals(",")) {
//                                tfHeQui.setText(stT.verPorc(tfHeQui.getText().trim()));
                            } else if (Double.parseDouble(tfHeQui.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeQui.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeQui.requestFocus();
                            } else {
//                                tfHeQui.setText(stT.verPorc(tfHeQui.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeQui.requestFocus();
                    }
                }
            }
        }
        );

        tfHeSex.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeSex.setText(tfHeSex.getText().substring(0, tfHeSex.getText().length() - 1));
                    tfHeSex.requestFocus();
                } else if (!tfHeSex.getText().trim().equals("")) {
                    if (tfHeSex.getText().substring(tfHeSex.getText().length() - 1).equals(".")) {
                        String g = tfHeSex.getText().substring(0, tfHeSex.getText().length() - 1);
                        g += ",";
                        tfHeSex.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeSex.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeSex.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeSex.getText().trim().equals("")) {
                            if (tfHeSex.getText().trim().equals(",")) {
//                                tfHeSex.setText(stT.verPorc(tfHeSex.getText().trim()));
                            } else if (Double.parseDouble(tfHeSex.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeSex.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeSex.requestFocus();
                            } else {
//                                tfHeSex.setText(stT.verPorc(tfHeSex.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeSex.requestFocus();
                    }
                }
            }
        }
        );

        tfHeSab.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeSab.setText(tfHeSab.getText().substring(0, tfHeSab.getText().length() - 1));
                    tfHeSab.requestFocus();
                } else if (!tfHeSab.getText().trim().equals("")) {
                    if (tfHeSab.getText().substring(tfHeSab.getText().length() - 1).equals(".")) {
                        String g = tfHeSab.getText().substring(0, tfHeSab.getText().length() - 1);
                        g += ",";
                        tfHeSab.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeSab.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeSab.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeSab.getText().trim().equals("")) {
                            if (tfHeSab.getText().trim().equals(",")) {
//                                tfHeSab.setText(stT.verPorc(tfHeSab.getText().trim()));
                            } else if (Double.parseDouble(tfHeSab.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeSab.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeSab.requestFocus();
                            } else {
//                                tfHeSab.setText(stT.verPorc(tfHeSab.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeSab.requestFocus();
                    }
                }
            }
        }
        );

        tfHeDom.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeDom.setText(tfHeDom.getText().substring(0, tfHeDom.getText().length() - 1));
                    tfHeDom.requestFocus();
                } else if (!tfHeDom.getText().trim().equals("")) {
                    if (tfHeDom.getText().substring(tfHeDom.getText().length() - 1).equals(".")) {
                        String g = tfHeDom.getText().substring(0, tfHeDom.getText().length() - 1);
                        g += ",";
                        tfHeDom.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeDom.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeDom.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeDom.getText().trim().equals("")) {
                            if (tfHeDom.getText().trim().equals(",")) {
//                                tfHeDom.setText(stT.verPorc(tfHeDom.getText().trim()));
                            } else if (Double.parseDouble(tfHeDom.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeDom.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeDom.requestFocus();
                            } else {
//                                tfHeDom.setText(stT.verPorc(tfHeDom.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeDom.requestFocus();
                    }
                }
            }
        }
        );

        tfHeFer.addKeyListener(
                new java.awt.event.KeyListener() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e
            ) {
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent e
            ) {
                int f = e.getKeyCode();
                if (f == e.VK_A
                        || f == e.VK_B
                        || f == e.VK_C
                        || f == e.VK_D
                        || f == e.VK_E
                        || f == e.VK_F
                        || f == e.VK_G
                        || f == e.VK_H
                        || f == e.VK_I
                        || f == e.VK_J
                        || f == e.VK_K
                        || f == e.VK_L
                        || f == e.VK_M
                        || f == e.VK_N
                        || f == e.VK_O
                        || f == e.VK_P
                        || f == e.VK_Q
                        || f == e.VK_R
                        || f == e.VK_S
                        || f == e.VK_T
                        || f == e.VK_U
                        || f == e.VK_V
                        || f == e.VK_W
                        || f == e.VK_X
                        || f == e.VK_Y
                        || f == e.VK_Z) {
                    JOptionPane.showMessageDialog(null, "Por favor, não digite letras nesse campo");
                    tfHeFer.setText(tfHeFer.getText().substring(0, tfHeFer.getText().length() - 1));
                    tfHeFer.requestFocus();
                } else if (!tfHeFer.getText().trim().equals("")) {
                    if (tfHeFer.getText().substring(tfHeFer.getText().length() - 1).equals(".")) {
                        String g = tfHeFer.getText().substring(0, tfHeFer.getText().length() - 1);
                        g += ",";
                        tfHeFer.setText(g);
                    }
                }
            }

            @Override
            public void keyTyped(java.awt.event.KeyEvent e
            ) {

            }
        });

        tfHeFer.addFocusListener(
                new FocusListener() {
//            StringTools stT = new StringTools();

            @Override
            public void focusGained(FocusEvent e
            ) {
            }

            @Override
            public void focusLost(FocusEvent e
            ) {
                String letras = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Ç,ç";
                String[] letra = letras.split(",");
                boolean let = false;
                for (String s : letra) {
                    if (tfHeFer.getText().trim().equals(s)) {
                        let = true;
                        break;
                    }
                }
                if (!let) {
                    try {
                        if (!tfHeFer.getText().trim().equals("")) {
                            if (tfHeFer.getText().trim().equals(",")) {
//                                tfHeFer.setText(stT.verPorc(tfHeFer.getText().trim()));
                            } else if (Double.parseDouble(tfHeFer.getText().replace(",", ".")) > 300 || Double.parseDouble(tfHeFer.getText().replace(",", ".")) < 0) {
                                JOptionPane.showMessageDialog(null, "Erro, O valor do Porcentual deve ser entre 300% e 0%");
                                tfHeFer.requestFocus();
                            } else {
//                                tfHeFer.setText(stT.verPorc(tfHeFer.getText().trim()));
                            }

                        }
                    } catch (Exception E) {
                        E.printStackTrace();
                        tfHeFer.requestFocus();
                    }
                }
            }
        }
        );

        chHeDiario.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeDiario.isSelected()) {
                    chHeDiaSem.setEnabled(false);
                } else if (!chHeSemana.isSelected()) {
                    chHeDiaSem.setEnabled(true);
                }
            }
        }
        );

        chHeSemana.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeSemana.isSelected()) {
                    chHeDiaSem.setEnabled(false);
                } else if (!chHeDiario.isSelected()) {
                    chHeDiaSem.setEnabled(true);
                }
            }
        }
        );

        chHeDiaSem.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeDiaSem.isSelected()) {
                    chHeDiario.setEnabled(false);
                    chHeSemana.setEnabled(false);
                } else {
                    chHeDiario.setEnabled(true);
                    chHeSemana.setEnabled(true);

                }
            }
        }
        );

        chHeSeg.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeSeg.isSelected()) {
                    tfHeSeg.setEnabled(true);
                    chHeSegAp.setEnabled(true);
                } else {
                    tfHeSeg.setEnabled(false);
                    tfHeSeg.setText("");
                    chHeSegAp.setEnabled(false);
                }
            }
        }
        );
        chHeTer.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeTer.isSelected()) {
                    tfHeTer.setEnabled(true);
                    chHeTerAp.setEnabled(true);
                } else {
                    tfHeTer.setEnabled(false);
                    tfHeTer.setText("");
                    chHeTerAp.setEnabled(false);
                }
            }
        }
        );
        chHeQua.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeQua.isSelected()) {
                    tfHeQua.setEnabled(true);
                    chHeQuaAp.setEnabled(true);
                } else {
                    tfHeQua.setEnabled(false);
                    tfHeQua.setText("");
                    chHeQuaAp.setEnabled(false);
                }
            }
        }
        );
        chHeQui.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeQui.isSelected()) {
                    tfHeQui.setEnabled(true);
                    chHeQuiAp.setEnabled(true);
                } else {
                    tfHeQui.setEnabled(false);
                    tfHeQui.setText("");
                    chHeQuiAp.setEnabled(false);
                }
            }
        }
        );
        chHeSex.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeSex.isSelected()) {
                    tfHeSex.setEnabled(true);
                    chHeSexAp.setEnabled(true);
                } else {
                    tfHeSex.setEnabled(false);
                    tfHeSex.setText("");
                    chHeSexAp.setEnabled(false);
                }
            }
        }
        );
        chHeSab.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeSab.isSelected()) {
                    tfHeSab.setEnabled(true);
                    chHeSabAp.setEnabled(true);
                } else {
                    tfHeSab.setEnabled(false);
                    tfHeSab.setText("");
                    chHeSabAp.setEnabled(false);
                }
            }
        }
        );
        chHeDom.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeDom.isSelected()) {
                    tfHeDom.setEnabled(true);
                    chHeDomAp.setEnabled(true);
                } else {
                    tfHeDom.setEnabled(false);
                    tfHeDom.setText("");
                    chHeDomAp.setEnabled(false);
                }
            }
        }
        );
        chHeFer.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (chHeFer.isSelected()) {
                    tfHeFer.setEnabled(true);
                    chHeFerAp.setEnabled(true);
                } else {
                    tfHeFer.setEnabled(false);
                    tfHeFer.setText("");
                    chHeFerAp.setEnabled(false);
                }
            }
        }
        );

        //fim das horas extras!
        tb1.add(pnGer,
                "Geral");//0
        tb1.add(pn58,
                "Art. 58 - Acomodação");//1
        tb1.add(pn66,
                "Art. 66 - 11 horas entrejornadas");//2
        tb1.add(pn71,
                "Art. 71 - Intrajornada tempo Mínimo/Máximo");//3
        tb1.add(pn72,
                "Art. 72 - Datilografia 10m a cada 1h30m");//4
        tb1.add(pn253,
                "Art. 253 - Frio 20m a cada 1h40m");//5
        tb1.add(pn36,
                "NR-36");//6
        tb1.add(pn384,
                "Art. 384 - Mulheres 15 minutos na prorrogação");//7
        tb1.add(pnAdc,
                "Adicionar Horário no Início/Fim da Jornada");//8
        tb1.add(pnSum,
                "Súmula 85 - Horas Dest. a Comp. (8h/48m)");//9
        tb1.add(pnAdcNot,
                "Adicional Noturno");//10
        tb1.add(pnHe,
                "Horas Extras");//11

        tb1.setEnabledAt(
                0, true);
        tb1.setEnabledAt(
                1, false);
        tb1.setEnabledAt(
                2, false);
        tb1.setEnabledAt(
                3, false);
        tb1.setEnabledAt(
                4, false);
        tb1.setEnabledAt(
                5, false);
        tb1.setEnabledAt(
                6, false);
        tb1.setEnabledAt(
                7, false);
        tb1.setEnabledAt(
                8, false);
        tb1.setEnabledAt(
                9, false);
        tb1.setEnabledAt(
                10, false);
        tb1.setEnabledAt(
                11, false);

        pnC.setLayout(
                new GridLayout(1, 1));
        pnC.add(tb1);

        cp.add(pnN, BorderLayout.NORTH);

        cp.add(pnC, BorderLayout.CENTER);

        cp.add(pnS, BorderLayout.SOUTH);

        cbPar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                tb1.setEnabledAt(0, false);
                tb1.setEnabledAt(1, false);
                tb1.setEnabledAt(2, false);
                tb1.setEnabledAt(3, false);
                tb1.setEnabledAt(4, false);
                tb1.setEnabledAt(5, false);
                tb1.setEnabledAt(6, false);
                tb1.setEnabledAt(7, false);
                tb1.setEnabledAt(8, false);
                tb1.setEnabledAt(9, false);
                tb1.setEnabledAt(10, false);
                tb1.setEnabledAt(11, false);
                switch (cbPar.getSelectedIndex()) {
                    case 0:
                    case 3:
                    case 9:
                        tb1.setEnabledAt(0, true);
                        tb1.setSelectedIndex(0);
                        break;
                    case 1:
                    case 2:
                        tb1.setEnabledAt(cbPar.getSelectedIndex(), true);
                        tb1.setSelectedIndex(cbPar.getSelectedIndex());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        tb1.setEnabledAt(cbPar.getSelectedIndex() - 1, true);
                        tb1.setSelectedIndex(cbPar.getSelectedIndex() - 1);
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        tb1.setEnabledAt(cbPar.getSelectedIndex() - 2, true);
                        tb1.setSelectedIndex(cbPar.getSelectedIndex() - 2);
                        break;
                    default:
                        tb1.setEnabledAt(0, true);
                        tb1.setSelectedIndex(0);
                        break;
                }
            }
        }
        );

//        String[] param = {
//        "Total das Horas Trabalhadas",0
//        "Art. 58 - Acomodação",1
//        "Art. 66 - 11 horas entrejornadas",2
//        "Art. 67 - 35 horas no final de semana",3
//        "Art. 71 - Intrajornada tempo Mínimo/Máximo",4
//        "Art. 72 - Datilografia 10m a cada 1h30m",5
//        "Art. 253 - Frio 20m a cada 1h40m",6
//        "NR-36",7
//        "Art. 384 - Mulheres 15 minutos na prorrogação",8
//        "Compensação (Jornada Digitada)",9
//        "Adicionar Horário no Início/Fim da Jornada",10
//        "Súmula 85 - Horas Dest. a Comp. (8h/48m)",11
//        "Adicional Noturno",12
//        "Horas Extras"13
//         };
        btSend.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
                switch (cbPar.getSelectedIndex()) {
                    case 0://Total de Horas trabalhadas
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível adicionar o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está Incompleta, por favor, insira a data válida!");
                        }
                        break;
                    case 1://Art. 58
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;

                    case 2://Art. 66
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 3://Art. 67
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 4://Art. 71
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (ch71Min.isSelected() && (tf71APartir.getText().trim().equals(":") || tf71APartir.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O tempo mínimo está selecionado, porém não foi informado o campo"
                                            + "\n \"Intervalo a partir do qual não se apura o Art. 71\"");
                                    tf71APartir.requestFocus();
                                } else if (ch71Max.isSelected() && (tf71Max.getText().trim().equals(":") || tf71Max.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo Máximo\" está marcado, porém\n"
                                            + "o campo de texto \"Intervalo máximo a partir do qual se apura o Art. 71\" \n"
                                            + "está vazio, ou é inválido!");
                                    tf71Max.requestFocus();
                                } else if (rb71Dif.isSelected() && (tf71Apurar1.getText().trim().equals(":") || tf71Apurar1.getText().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apurar apenas a diferença - ou\" "
                                            + "\n está selecionado, porém não há parâmetros, ou o parâmetro é inválido!");
                                    tf71Apurar1.requestFocus();
                                } else if (rb71Fix.isSelected() && (tf71Apurar2.getText().trim().equals(":") || tf71Apurar2.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apurar tempo fixo de\" está selecionado"
                                            + "\n porém, não há parâmetros, ou o parâmetro é inválido");
                                    tf71Apurar2.requestFocus();
                                } else if (ch71Exc.isSelected() && tf71Exc.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Exceto X dias na semana\" está marcado"
                                            + "\nPorém, não há parâmetros no campo de texto");
                                    tf71Exc.requestFocus();
                                } else if (ch71Semp.isSelected() && tf71Semp.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Sempre X dias na semana\" está marcado"
                                            + "\nPorém, não há parâmetros no campo de texto");
                                    tf71Semp.requestFocus();
                                } else if (!ch71Max.isSelected() && !ch71Min.isSelected()) {
                                    JOptionPane.showMessageDialog(null, "Por favor, selecione o Tempo Mínimo ou Máximo!");
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 5://Art. 72
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tf72Int.getText().trim().equals(":") || tf72Int.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo de Intervalo\" está com algum erro."
                                            + "\nPor favor, insira um valor válido!");
                                    tf72Int.requestFocus();
                                } else if (tf72Acad.getText().trim().equals(":") || tf72Acad.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"A cada (Qtd. H. Trabalhada) \" está com algum erro."
                                            + "\n Por favor, insira um valor válido!");
                                    tf72Acad.requestFocus();
                                } else if (ch72AbFolg.isSelected() && (tf72LimDe.getText().trim().equals(":") || tf72LimDe.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Abater Folgas Concedidas Até o Limite De\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou com um valor inválido.\n"
                                            + "Por favor, digite um valor válido!");
                                    tf72LimDe.requestFocus();
                                } else if (ch72LimCalcA.isSelected() & (tf72CalcA.getText().trim().equals(""))) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos a:\" está marcado."
                                            + "\n Porém, o campo de texto está vazio!\n"
                                            + "Por favor digite um número de dias no campo!");
                                    tf72CalcA.requestFocus();
                                } else if (ch72LimCalcAte.isSelected() && (tf72LimCalcAte.getText().trim().equals(":") || tf72LimCalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos até a\" está marcado.\n"
                                            + "Entretanto, o campo de texto está vazio ou inválido."
                                            + "\nPor favor, digite um valor válido!");
                                    tf72LimCalcAte.requestFocus();
                                } else if (ch72CalcAte.isSelected() && (tf72CalcAte.getText().trim().equals(":") || tf72CalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente até as\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf72CalcAte.requestFocus();
                                } else if (ch72CalcApart.isSelected() && (tf72CalcApart.getText().trim().equals(":") || tf72CalcApart.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente a partir das\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira um valor válido!");
                                    tf72CalcApart.requestFocus();
                                } else if (ch72IntFirst.isSelected() && (tf72IntFixFirst.getText().trim().equals(":") || tf72IntFixFirst.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na primeira/única Semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf72IntFixFirst.requestFocus();
                                } else if (ch72IntSeg.isSelected() && (tf72IntFixSeg.getText().trim().equals(":") || tf72IntFixSeg.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na segunda semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf72IntFixSeg.requestFocus();
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 6://Art. 253
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tf253Int.getText().trim().equals(":") || tf253Int.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo de Intervalo\" está com algum erro."
                                            + "\nPor favor, insira um valor válido!");
                                    tf253Int.requestFocus();
                                } else if (tf253Acad.getText().trim().equals(":") || tf253Acad.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"A cada (Qtd. H. Trabalhada) \" está com algum erro."
                                            + "\n Por favor, insira um valor válido!");
                                    tf253Acad.requestFocus();
                                } else if (ch253AbFolg.isSelected() && (tf253LimDe.getText().trim().equals(":") || tf253LimDe.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Abater Folgas Concedidas Até o Limite De\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou com um valor inválido.\n"
                                            + "Por favor, digite um valor válido!");
                                    tf253LimDe.requestFocus();
                                } else if (ch253LimCalcA.isSelected() & (tf253CalcA.getText().trim().equals(""))) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos a:\" está marcado."
                                            + "\n Porém, o campo de texto está vazio!\n"
                                            + "Por favor digite um número de dias no campo!");
                                    tf253CalcA.requestFocus();
                                } else if (ch253LimCalcAte.isSelected() && (tf253LimCalcAte.getText().trim().equals(":") || tf253LimCalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos até a\" está marcado.\n"
                                            + "Entretanto, o campo de texto está vazio ou inválido."
                                            + "\nPor favor, digite um valor válido!");
                                    tf253LimCalcAte.requestFocus();
                                } else if (ch253CalcAte.isSelected() && (tf253CalcAte.getText().trim().equals(":") || tf253CalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente até as\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf253CalcAte.requestFocus();
                                } else if (ch253CalcApart.isSelected() && (tf253CalcApart.getText().trim().equals(":") || tf253CalcApart.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente a partir das\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira um valor válido!");
                                    tf253CalcApart.requestFocus();
                                } else if (ch253IntFirst.isSelected() && (tf253IntFixFirst.getText().trim().equals(":") || tf253IntFixFirst.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na primeira/única Semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf253IntFixFirst.requestFocus();
                                } else if (ch253IntSeg.isSelected() && (tf253IntFixSeg.getText().trim().equals(":") || tf253IntFixSeg.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na segunda semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf253IntFixSeg.requestFocus();
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 7://Nr-36
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tf36Int.getText().trim().equals(":") || tf36Int.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo de Intervalo\" está com algum erro."
                                            + "\nPor favor, insira um valor válido!");
                                    tf36Int.requestFocus();
                                } else if (tf36Acad.getText().trim().equals(":") || tf36Acad.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"A cada (Qtd. H. Trabalhada) \" está com algum erro."
                                            + "\n Por favor, insira um valor válido!");
                                    tf36Acad.requestFocus();
                                } else if (ch36AbFolg.isSelected() && (tf36LimDe.getText().trim().equals(":") || tf36LimDe.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Abater Folgas Concedidas Até o Limite De\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou com um valor inválido.\n"
                                            + "Por favor, digite um valor válido!");
                                    tf36LimDe.requestFocus();
                                } else if (ch36LimCalcA.isSelected() & (tf36CalcA.getText().trim().equals(""))) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos a:\" está marcado."
                                            + "\n Porém, o campo de texto está vazio!\n"
                                            + "Por favor digite um número de dias no campo!");
                                    tf36CalcA.requestFocus();
                                } else if (ch36LimCalcAte.isSelected() && (tf36LimCalcAte.getText().trim().equals(":") || tf36LimCalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Limitar os Cálculos até a\" está marcado.\n"
                                            + "Entretanto, o campo de texto está vazio ou inválido."
                                            + "\nPor favor, digite um valor válido!");
                                    tf36LimCalcAte.requestFocus();
                                } else if (ch36CalcAte.isSelected() && (tf36CalcAte.getText().trim().equals(":") || tf36CalcAte.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente até as\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf36CalcAte.requestFocus();
                                } else if (ch36CalcApart.isSelected() && (tf36CalcApart.getText().trim().equals(":") || tf36CalcApart.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Calcular somente a partir das\" está selecionado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira um valor válido!");
                                    tf36CalcApart.requestFocus();
                                } else if (ch36IntFirst.isSelected() && (tf36IntFixFirst.getText().trim().equals(":") || tf36IntFixFirst.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na primeira/única Semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf36IntFixFirst.requestFocus();
                                } else if (ch36IntSeg.isSelected() && (tf36IntFixSeg.getText().trim().equals(":") || tf36IntFixSeg.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Intervalo fixo na segunda semana\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira valores válidos!");
                                    tf36IntFixSeg.requestFocus();
                                } else if (ch36M9h50.isSelected() && (tf36Int.getText().trim().equals(":") || tf36Int.getText().trim().length() < 5 || tf36Acad.getText().trim().equals(":") || tf36Acad.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Até 9h58m\" está selecionado!\n"
                                            + "Porém, o campo de texto \"Tempo de Intervalo\" ou\n"
                                            + "\"A cada (Qtd. H. Trabalhada)\" está(ão) em branco ou inválidos!\n"
                                            + "Por favor, Digite horários válidos para os 2 campos!");
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 8://Art. 384
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tf384Int.getText().trim().equals(":") || tf384Int.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo de Intervalo\" está em branco ou incompleto\n"
                                            + "Por favor, insira um registro válido!");
                                    tf384Int.requestFocus();
                                } else if (tf384Sup.getText().trim().equals(":") || tf384Sup.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apurar somente se as H.E. for superior a\"\n"
                                            + "está vazio ou incompleto.\n"
                                            + "Por favor, insira um registro válido!");
                                    tf384Sup.requestFocus();
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 9://Compensação
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 10://Adicionar Horário no Inicio/fim da Jorn
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tfAdcDesc.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo de texto \"Descrição da Verba\" está vazio!\n"
                                            + "Por favor, digite a descrição da verba");
                                    tfAdcDesc.requestFocus();
                                } else if (tfAdcQntAnt.getText().trim().equals(":") || tfAdcQntAnt.getText().trim().equals("") || tfAdcQntAnt.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo de texto \"Qtd. Tempo a Adicionar antes do início da Jornada\"\n"
                                            + "Está incompleto ou vazio!\n"
                                            + "Por favor, insira uma hora válida!");
                                    tfAdcQntAnt.requestFocus();
                                } else if (tfAdcQntDps.getText().trim().equals(":") || tfAdcQntDps.getText().trim().equals("") || tfAdcQntDps.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo de texto \"Qtd. Tempo a Adicionar Após o Término da Jornada\" \n"
                                            + "Está incompleto ou vazio!\n"
                                            + "Por favor, insira um horário válido");
                                    tfAdcQntDps.requestFocus();
                                } else if (chAdcAntSe.isSelected() && (tfAdcQntAntSe.getText().trim().equals(":") || tfAdcQntAntSe.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Se a jornada Iniciar antes das:\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio, ou incompleto!\n"
                                            + "Por favor, Insira um horário válido!");
                                    tfAdcQntAntSe.requestFocus();
                                } else if (chAdcDpsSe.isSelected() && (tfAdcQntDpsSe.getText().trim().equals(":") || tfAdcQntDpsSe.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Se a jornada terminar após as\" está marcado.\n"
                                            + "Porém, o campo de texto está vazio ou incompleto!\n"
                                            + "Por favor, Insira um horário válido!");
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 11://Súmula 85
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (tfSumJorn.getText().trim().equals(":") || tfSumJorn.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Jornada a partir do qual haverá compensação\"\n"
                                            + "está vazio ou incompleto!\n"
                                            + "Por favor, insira um horário válido!");
                                    tfSumJorn.requestFocus();
                                } else if (tfSumTemp.getText().trim().equals(":") || tfSumTemp.getText().trim().length() < 5) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Tempo máximo destinado à compensação\"\n"
                                            + "está vazio ou incompleto!\n"
                                            + "Por favor, insira um horário válido!");
                                    tfSumTemp.requestFocus();
                                } else if (tfSumQnt.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Qtd. folga semanal a partir da quel não\n"
                                            + "haverá apuração das horas a compensar\"\n"
                                            + "Está vazio ou incompleto!\n"
                                            + "Por favor, insira um horário válido!");
                                    tfSumQnt.requestFocus();
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 12://Adicional Noturno
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (chAdcNotRed.isSelected()
                                        && (tfAdcNotHorDas.getText().trim().equals(":") || tfAdcNotHorDas.getText().trim().length() < 5
                                        || tfAdcNotHorAs.getText().trim().equals(":") || tfAdcNotHorAs.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Redução da Hora Noturna\" Está selecionado."
                                            + "Entretanto, algum dos campos de texto está vazio ou incompleto!\n"
                                            + "Por favor, insira horários válidos nos dois campos!");
                                } else {
                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;
                    case 13://Horas Extras
                        if (!tfPerIn.getText().trim().equals("/  /") && !tfPerSai.getText().trim().equals("/  /")) {
                            try {
                                if (chHeDupTri.isSelected() && (tfHeFaixa1.getText().trim().equals(":") || tfHeFaixa1.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Horas extras duplas/triplas\" está selecionado\n"
                                            + "Entretanto, o campo da faixa 1 está vazio ou incompleto!\n"
                                            + "Por favor, insira um horário válido na primeira faixa!");
                                    tfHeFaixa1.requestFocus();
                                } else if (!tfHeFaixa1.getText().trim().equals(":") && (!tfHeFaixa2.getText().trim().equals(":") && tfHeFaixa2.getText().trim().length() < 5)) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Horas extras duplas/triplas\" está selecionado\n"
                                            + "O campo faixa1 está preenchido, entretanto a faixa2\n"
                                            + "está incompleta!\n"
                                            + "Por favor, insira um horário válido ou deixe o campo em branco!");
                                    tfHeFaixa2.requestFocus();
                                } else if (chHeSegAp.isSelected() && tfHeSeg.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Segunda feira está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeSeg.requestFocus();
                                } else if (chHeTerAp.isSelected() && tfHeTer.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Terça feira está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeTer.requestFocus();
                                } else if (chHeQuaAp.isSelected() && tfHeQua.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Quarta feira está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeQua.requestFocus();
                                } else if (chHeQuiAp.isSelected() && tfHeQui.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Quinta feira está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeQui.requestFocus();
                                } else if (chHeSexAp.isSelected() && tfHeSex.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Sexta feira está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeSex.requestFocus();
                                } else if (chHeSabAp.isSelected() && tfHeSab.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Sábado está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeSab.requestFocus();
                                } else if (chHeDomAp.isSelected() && tfHeDom.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Domingo está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeDom.requestFocus();
                                } else if (chHeFerAp.isSelected() && tfHeFer.getText().trim().equals("")) {
                                    JOptionPane.showMessageDialog(null, "O campo \"Apura Agrupado\" de Feriado está marcado!\n"
                                            + "entretanto, o campo de texto está vazio ou inválido!");
                                    tfHeFer.requestFocus();
                                } else {

                                }
                            } catch (Exception E) {
                                E.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Não foi possível inserir o registro!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Alguma das datas do Período está incompleta, por favor, insira uma data válida!");
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar, não foi possível identificar o índice do JComboBox\nRequerido! Por favor, entre em contato com o Programador!");
                        break;
                }
            }
        }
        );

        btCanc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesenharChaveDialogTest();
            }
        });
    }
}
