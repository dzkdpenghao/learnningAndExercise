/**
 * Author:   80303990
 * Date:     2020/10/20 15:23
 * Description: 磁盘的电梯调度算法
 */
package exercise.penghao;

import java.util.*;

public class ElevatorSchedulingAlgorithm {

    public static void main(String[] args) {
        //初始化,设置一些初始值
        int originalCount = random.nextInt(5) + 5;
        for (int i = 0; i < originalCount; i++) {
            PCB temp = new PCB(i, random.nextInt(200) + 1, false);
            outPCBs.add(temp);
            inPCBs.add(temp);
        }
        count = originalCount;
        isOutDirection = random.nextInt(200) > 100 ? true : false;
        currentCiDaoNum = random.nextInt(200) + 1;
        // 描述当前状态
        System.out.println("请求I/O表中有以下进程项:");
        Iterator<PCB> iterator = outPCBs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("当前移臂方向为:" + (isOutDirection ? "从内向外" : "从外向内"));
        System.out.println("当前所访问的磁道为:" + currentCiDaoNum);
        System.out.println();
        System.out.println();

        while (true) {
            System.out.println("请输入0或者1：0代表进行调度，1代表接受新的I/O请求:");
            int x = sc.nextInt();
            if (x == 0) {
                diskScheduling();
            } else if (x == 1) {
                acceptRequest(++originalCount);
            }
            continue;
        }
    }

    //按从内到外的顺序排列的请求线程
    public static TreeSet<PCB> outPCBs = new TreeSet<>(new Comparator<PCB>() {
        @Override
        public int compare(PCB o1, PCB o2) {
            if (o1.getCiDaoNum() >= o2.getCiDaoNum()) {
                if (o1.getCiDaoNum() == o2.getCiDaoNum()) {
                    return 0;
                }
                return 1;
            }
            return -1;
        }
    });
    //按从外向内的顺序排列的请求线程
    public static TreeSet<PCB> inPCBs = new TreeSet<>(new Comparator<PCB>() {
        @Override
        public int compare(PCB o1, PCB o2) {
            if (o1.getCiDaoNum() >= o2.getCiDaoNum()) {
                if (o1.getCiDaoNum() == o2.getCiDaoNum()) {
                    return 0;
                }
                return -1;
            }
            return 1;
        }
    });
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();
    //当前所在磁道数
    public static int currentCiDaoNum;
    //当前请求磁盘IO的进程数
    public static int count;
    //当前磁道扫描方向
    public static Boolean isOutDirection;

    /**
     * 功能描述: 接受新的磁盘I/O请求
     * 〈〉
     *
     * @param: id:进程id
     * @Author:80303990
     * @Date: 2020/10/20 15:47
     */
    private static void acceptRequest(int id) {
        System.out.println("请输入进程要访问的磁道号(保证磁道号在1~200内)：");
        int Num = sc.nextInt();
        PCB temp = new PCB(id, Num, false);
        outPCBs.add(temp);
        inPCBs.add(temp);
        count++;
        System.out.println("该进程已被成功添加至请求I/O表!!");
        System.out.println();
        System.out.println();
        System.out.println("目前请求I/O表已经具备以下表项:");
        Iterator<PCB> iterator = outPCBs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("此时磁臂方向为：" + (isOutDirection ? "从内向外" : "从外向内") + ".");
        System.out.println("此时磁臂所在磁道的号码为：" + currentCiDaoNum);
    }

    /**
     * 功能描述: 进行磁盘调度
     * 〈〉
     *
     * @Author:80303990
     * @Date: 2020/10/20 15:49
     */
    private static void diskScheduling() {
        if (count <= 0) {
            System.out.println("请求I/O表已空，请添加请求后再进行磁盘调度或者退出程序。");
            return;
        }
        System.out.println("开始在" + currentCiDaoNum + "磁道上并" + (isOutDirection ? "从内向外" : "从外向内") + "方向上查询--");
        Iterator<PCB> iterator = null;
        boolean isFindWithOneDirection = false;
        PCB targetPCB = null;

        if (isOutDirection) {
            //目前扫描方向是从内向外

            iterator = outPCBs.iterator();
            while (iterator.hasNext()) {
                PCB pcb = iterator.next();
                if (pcb.getCiDaoNum() < currentCiDaoNum) continue;
                targetPCB = pcb;

                iterator.remove();
                if (inPCBs.contains(pcb)) {
                    inPCBs.remove(pcb);
                }

                isFindWithOneDirection = true;
                break;
            }
            if (!isFindWithOneDirection) {
                isOutDirection = false;
            }
        } else {
            //目前扫描方向是从内向外

            iterator = inPCBs.iterator();
            while (iterator.hasNext()) {
                PCB pcb = iterator.next();
                if (pcb.getCiDaoNum() > currentCiDaoNum) continue;
                targetPCB = pcb;

                iterator.remove();
                if (outPCBs.contains(pcb)) {
                    outPCBs.remove(pcb);
                }

                isFindWithOneDirection = true;
                break;
            }
            if (!isFindWithOneDirection) {
                isOutDirection = true;
            }
        }

        if (!isFindWithOneDirection) {
            //如果朝一个方向没有找到，则直接调转方向拿第一个
            if (isOutDirection) {
                targetPCB = outPCBs.pollFirst();
                inPCBs.pollLast();
            } else {
                targetPCB = inPCBs.pollFirst();
                outPCBs.pollLast();
            }
            System.out.println("在当前方向上没有查询到，转变磁臂方向查找," + "找到在" + targetPCB.getCiDaoNum() + "磁道上且进程编号为" + targetPCB.getId() + "的进程。");
        } else {
            //朝目前这个方向找到了，输出它
            System.out.println("在当前方向上找到符合要求的进程," + "其所在磁道号为：" + targetPCB.getCiDaoNum() + ",进程编号为:" + targetPCB.getId());
        }

        currentCiDaoNum = targetPCB.getCiDaoNum();
        count--;

        System.out.println("此时磁臂方向为：" + (isOutDirection ? "从内向外" : "从外向内") + ".");
        System.out.println("此时磁臂所在磁道的号码为：" + currentCiDaoNum);

    }


}

//进行磁盘I/O请求的进程类
class PCB {
    private int id;
    private int ciDaoNum;

    public PCB(int id, int ciDaoNum, boolean isVisited) {
        this.id = id;
        this.ciDaoNum = ciDaoNum;
    }


    @Override
    public String toString() {
        return "进程ID：" + this.getId() + "___请求的磁道：" + this.getCiDaoNum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCiDaoNum() {
        return ciDaoNum;
    }

    public void setCiDaoNum(int ciDaoNum) {
        this.ciDaoNum = ciDaoNum;
    }

}
