import { BrigadeOrder } from './brigadeOrder';
import { Korpus } from './korpus';
import { Tmk } from './tmk';

export interface KorpusOrder {
    id?: number;
    tmk?: Tmk;
    korpus?: Korpus;
    brigadeOrders?: BrigadeOrder[];
}
