import { Brigade } from './brigade';
import { Rank } from './rank';
import { Tmk } from './tmk';

export interface BrigadeOrder {
    id?: number;
    brigade?: Brigade;
    tmk?: Tmk;
    brigadeRanks?: Rank[];
}
