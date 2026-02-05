class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        int attackCount = 0; // 몬스터의 공격 횟수
        int healCount = 0;
        int time = 1;
        while (attackCount < attacks.length) {
            
            // 현재가 몬스터 공격 턴이라면
            if (attacks[attackCount][0] == time) {
                // 연속 성공도 초기화
                health -= attacks[attackCount][1];
                attackCount++;
                healCount = 0;
            } else {
                // 아니면 힐 하고 연속 성공 적립
                health = Math.min(maxHealth, health + bandage[1]);
                healCount++;
                if (healCount == bandage[0]) {
                    healCount = 0;
                    health = Math.min(maxHealth, health + bandage[2]);
                }
            }
            System.out.println("health: " + health);
            
            // 체력 0되면 끝
            if (health <= 0) return -1;
            time++;
        }
        
        return health;
    }
}