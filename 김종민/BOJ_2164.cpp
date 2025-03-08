#include <iostream>
#include <deque>

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto N = 0;
    std::cin >> N;

    auto deque = std::deque<int>();
    for(int i = 0; i < N; i++)
        deque.push_back(i + 1);
    
    auto flag = false;
    while(deque.size() != 1)
    {
        if(flag)
            deque.push_back(deque.front());

        deque.pop_front();

        flag = !flag;
    }

    std::cout << deque.front() << '\n';

    return 0;
}