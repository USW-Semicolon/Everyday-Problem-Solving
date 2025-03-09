#include <iostream>
#include <deque>

using PII = std::pair<int, int>;

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto ballon_count = 0;
    std::cin >> ballon_count;
    
    auto circuit = std::deque<PII>();
    auto input = 0;
    for(int i = 0; i < ballon_count; i++)
    {
        std::cin >> input;
        circuit.push_back(std::make_pair(i + 1, input));
    }
    
    auto target = 0;
    while(!circuit.empty())
    {
        if(target > 0)
        {
            for(int i = 0; i < std::abs(target); i++)
            {
                circuit.push_back(circuit.front());
                circuit.pop_front();
            }
        }
        else if(target < 0)
        {
            for(int i = 0; i < std::abs(target); i++)
            {
                circuit.push_front(circuit.back());
                circuit.pop_back();
            }
        }

        auto temp = circuit.front().second;

        std::cout << circuit.front().first << " ";
        circuit.pop_front();

        target = temp > 0 ? temp - 1 : temp;
    }
    std::cout << '\n';

    return 0;
}