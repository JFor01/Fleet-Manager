import {Indexable} from './Indexable';

export interface Driver extends Indexable {
  active : boolean;
  age : number;
  name : string;
}

export type DriverRequest = {
  name : string;
  age :string;
}
