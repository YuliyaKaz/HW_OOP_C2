package Classes;
/*
 * @apiNote Акция
 * nameAction - название акции
 * numsParticipant - количество участников акции
 * maximunNumsParticipant - максимальное количество участников акции
 */
public class Action {
    private String nameAction; //название акции
    private static int numsParticipant; //количество участников
    private static final int maximumNumsParticipant = 2; //максимальное количество участников акции
    
    public Action(String nameAction) {
        setName(nameAction);
    }
    /*
    * @apiNote присвоить название акции
    */
    public void setName(String name){
        this.nameAction = name;
    };

    /*
     * @apiNote getter-метод название акции
     */
    public String getName(){
        return this.nameAction;
    }
    /*
     * @apiNote Добавить участника в акцию
     */
    public void addActionParticipant(){
        numsParticipant++;
    }
    /*
     * @apiNote Узнать количество участников акции
     */
    public int getNumsActionParticipant(){
        return numsParticipant;
    }
    /*
     * @apiNote Возвращает номер участника акции
     */
    public int geIdActionClient(){
        addActionParticipant();
        return numsParticipant;
    }
    /*
     * @apiNote Возвращает максимальное количество участников данной акции
     */
    public static int getMaximumNumsParticipant(){
        return maximumNumsParticipant;
    }
    
}
