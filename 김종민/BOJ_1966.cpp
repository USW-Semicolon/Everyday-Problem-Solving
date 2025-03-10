#include <iostream>
#include <queue>

using PII = std::pair<int, int>;

struct Temp
{
    bool operator() (const PII& p1, const PII& p2)
    {
        return p1.second < p2.second;
    }
};

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto test_case_count = 0;
    std::cin >> test_case_count;

    auto answer_queue = std::queue<int>();

    for(int i = 0; i < test_case_count; i++)
    {
        auto queue = std::queue<PII>();
        auto priority_queue = std::priority_queue<int>();

        auto count = 0, where = 0;
        std::cin >> count >> where;

        auto priority = 0;
        for(int i = 0; i < count; i++)
        {
            std::cin >> priority;
            queue.push(std::make_pair(i, priority));
            priority_queue.push(priority);
        }

        auto answer = 0;
        while(!priority_queue.empty())
        {
            auto front = queue.front();
            queue.pop(); 

            if(front.second == priority_queue.top())
            {
                answer++;
                priority_queue.pop();

                if(front.first == where)
                {
                    answer_queue.push(answer);
                    break;
                }
            }
            else
            {
                queue.push(front);
            }
        }
    }

    while(!answer_queue.empty())
    {
        std::cout << answer_queue.front() << '\n';
        answer_queue.pop();
    }

    return 0;
}